import javax.imageio.ImageIO;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Generates every app-icon artifact from one square source PNG.
 *
 * Usage: java IconGen.java <src.png> <repoRoot>
 *
 * Outputs
 *  - Android legacy mipmaps  res/mipmap-<dpi>/ic_launcher.png        (rounded square)
 *  - Android legacy mipmaps  res/mipmap-<dpi>/ic_launcher_round.png  (circle)
 *  - Adaptive layer          res/mipmap-<dpi>/ic_launcher_foreground.png
 *  - Adaptive config         res/mipmap-anydpi-v26/ic_launcher{,_round}.xml
 *  - Background colour       res/values/ic_launcher_background.xml   (sampled from art)
 *  - iOS asset catalog       iosApp/iosApp/Assets.xcassets/AppIcon.appiconset/
 *  - Store/marketing PNG     docs/app-icon-512.png
 *  - Windows launcher ICO    composeApp/icons/RoveCamLink.ico
 */
public final class IconGen {

    /**
     * Foreground art occupies this fraction of the 108dp adaptive canvas. 0.76 is chosen so the
     * 66dp circular safe zone still shows the character's whole head, including the ear tips.
     */
    static final double FG_SCALE = 0.76;
    /** Corner radius as a fraction of side length for legacy (pre-26) icons. */
    static final double LEGACY_CORNER = 0.225;

    static final String[][] DENSITY = {
        {"mdpi", "48", "108"},
        {"hdpi", "72", "162"},
        {"xhdpi", "96", "216"},
        {"xxhdpi", "144", "324"},
        {"xxxhdpi", "192", "432"},
    };

    public static void main(String[] args) throws Exception {
        File src = new File(args[0]);
        File root = new File(args[1]);
        BufferedImage art = ImageIO.read(src);
        System.out.println("source " + art.getWidth() + "x" + art.getHeight()
            + " type=" + art.getType() + " alpha=" + art.getColorModel().hasAlpha());

        Color bg = sampleBorder(art);
        String hex = String.format(Locale.ROOT, "#%02X%02X%02X", bg.getRed(), bg.getGreen(), bg.getBlue());
        System.out.println("sampled background = " + hex);

        File res = new File(root, "composeApp/src/androidMain/res");
        for (String[] d : DENSITY) {
            int legacy = Integer.parseInt(d[1]);
            int adaptive = Integer.parseInt(d[2]);
            File dir = new File(res, "mipmap-" + d[0]);
            dir.mkdirs();
            writePng(rounded(art, legacy, LEGACY_CORNER), new File(dir, "ic_launcher.png"));
            writePng(rounded(composite(art, bg, legacy, FG_SCALE), legacy, 0.5),
                new File(dir, "ic_launcher_round.png"));
            writePng(foreground(art, adaptive), new File(dir, "ic_launcher_foreground.png"));
            System.out.println("mipmap-" + d[0] + ": " + legacy + "px legacy, " + adaptive + "px foreground");
        }

        File anydpi = new File(res, "mipmap-anydpi-v26");
        anydpi.mkdirs();
        writeAdaptiveXml(new File(anydpi, "ic_launcher.xml"));
        writeAdaptiveXml(new File(anydpi, "ic_launcher_round.xml"));
        writeColor(new File(res, "values/ic_launcher_background.xml"), hex);

        // iOS: single-size universal 1024, opaque (App Store rejects alpha in app icons).
        // Full bleed — iOS applies its own squircle mask, and insetting would expose a seam
        // because the artwork's backdrop is vignetted rather than a flat colour.
        File appicon = new File(root, "iosApp/iosApp/Assets.xcassets/AppIcon.appiconset");
        appicon.mkdirs();
        writeCatalog(new File(root, "iosApp/iosApp/Assets.xcassets/Contents.json"));
        writePng(opaque(scale(art, 1024, 1024)), new File(appicon, "AppIcon-1024.png"));
        writeAppIconContents(new File(appicon, "Contents.json"));

        File docs = new File(root, "docs");
        docs.mkdirs();
        writePng(rounded(art, 512, LEGACY_CORNER), new File(docs, "app-icon-512.png"));

        // Windows: one .ico carrying every size the shell asks for. jpackage embeds it into the
        // launcher exe, so without it the window, the taskbar button and the Start-menu shortcut
        // all fall back to Java's default cup icon.
        writeIco(new File(root, "composeApp/icons/RoveCamLink.ico"), art);
        System.out.println("done");
    }

    /** Largest first: the shell picks the first entry that covers the size it needs. */
    static final int[] ICO_SIZES = {256, 128, 64, 48, 32, 16};

    /**
     * ICO container. Entries of 64px and up are PNG-compressed (that is how a 256px entry has to
     * be stored); the shell's small sizes stay classic 32bpp DIBs, which every reader of an .ico
     * resource — WiX's resource compiler, Explorer, the taskbar — is guaranteed to accept.
     */
    static void writeIco(File f, BufferedImage art) throws Exception {
        byte[][] images = new byte[ICO_SIZES.length][];
        for (int i = 0; i < ICO_SIZES.length; i++) {
            int size = ICO_SIZES[i];
            BufferedImage img = rounded(art, size, LEGACY_CORNER);
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            if (size >= 64) {
                if (!ImageIO.write(img, "png", buf)) throw new IllegalStateException("no PNG writer");
            } else {
                buf.write(dib(img));
            }
            images[i] = buf.toByteArray();
        }

        f.getParentFile().mkdirs();
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(f))) {
            le16(out, 0);                    // reserved
            le16(out, 1);                    // resource type: icon
            le16(out, ICO_SIZES.length);
            int offset = 6 + 16 * ICO_SIZES.length;
            for (int i = 0; i < ICO_SIZES.length; i++) {
                int dim = ICO_SIZES[i] >= 256 ? 0 : ICO_SIZES[i];   // 0 is how 256 is encoded
                out.write(dim);              // width
                out.write(dim);              // height
                out.write(0);                // palette entries
                out.write(0);                // reserved
                le16(out, 1);                // colour planes
                le16(out, 32);               // bits per pixel
                le32(out, images[i].length);
                le32(out, offset);
                offset += images[i].length;
            }
            for (byte[] image : images) out.write(image);
        }
        System.out.println("ico: " + ICO_SIZES.length + " sizes");
    }

    /**
     * 32bpp BGRA bottom-up DIB followed by the 1bpp AND mask, without a BITMAPFILEHEADER — the
     * form an ICO entry uses. The mask is left all zero because the alpha channel already
     * carries the rounded corners.
     */
    static byte[] dib(BufferedImage img) {
        int size = img.getWidth();
        int maskRow = ((size + 31) / 32) * 4;
        ByteBuffer buf = ByteBuffer
            .allocate(40 + size * size * 4 + maskRow * size)
            .order(ByteOrder.LITTLE_ENDIAN);
        buf.putInt(40);                       // biSize
        buf.putInt(size);
        buf.putInt(size * 2);                 // XOR bitmap stacked with the AND mask
        buf.putShort((short) 1);              // biPlanes
        buf.putShort((short) 32);             // biBitCount
        buf.putInt(0);                        // BI_RGB
        buf.putInt(size * size * 4 + maskRow * size);
        for (int i = 0; i < 4; i++) buf.putInt(0);   // ppm x/y, clrUsed, clrImportant
        for (int y = size - 1; y >= 0; y--) {
            for (int x = 0; x < size; x++) {
                int p = img.getRGB(x, y);
                buf.put((byte) p);                    // B
                buf.put((byte) (p >> 8));             // G
                buf.put((byte) (p >> 16));            // R
                buf.put((byte) (p >> 24));            // A
            }
        }
        return buf.array();
    }

    static void le16(OutputStream out, int v) throws IOException {
        out.write(v & 0xFF);
        out.write((v >> 8) & 0xFF);
    }

    static void le32(OutputStream out, int v) throws IOException {
        for (int s = 0; s < 32; s += 8) out.write((v >> s) & 0xFF);
    }

    /**
     * Dominant border colour, i.e. the artwork's own backdrop. A plain average would mix in the
     * white hair that crosses the frame edge, so pixels are bucketed (4 bits/channel) and the
     * largest bucket is averaged.
     */
    static Color sampleBorder(BufferedImage img) {
        int w = img.getWidth(), h = img.getHeight();
        int band = Math.max(1, w / 40);
        Map<Integer, long[]> buckets = new HashMap<>();
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                boolean edge = x < band || y < band || x >= w - band || y >= h - band;
                if (!edge) continue;
                int p = img.getRGB(x, y);
                int r = (p >> 16) & 0xFF, g = (p >> 8) & 0xFF, b = p & 0xFF;
                int key = ((r >> 4) << 8) | ((g >> 4) << 4) | (b >> 4);
                long[] acc = buckets.computeIfAbsent(key, k -> new long[4]);
                acc[0] += r;
                acc[1] += g;
                acc[2] += b;
                acc[3]++;
            }
        }
        long[] top = buckets.values().stream().max(Comparator.comparingLong(a -> a[3])).orElseThrow();
        List<Map.Entry<Integer, long[]>> ranked = buckets.entrySet().stream()
            .sorted((a, b) -> Long.compare(b.getValue()[3], a.getValue()[3]))
            .limit(3).toList();
        StringBuilder sb = new StringBuilder("border colour buckets (top3): ");
        for (Map.Entry<Integer, long[]> e : ranked) {
            long[] a = e.getValue();
            sb.append(String.format(Locale.ROOT, "#%02X%02X%02X x%d  ",
                a[0] / a[3], a[1] / a[3], a[2] / a[3], a[3]));
        }
        System.out.println(sb);
        return new Color((int) (top[0] / top[3]), (int) (top[1] / top[3]), (int) (top[2] / top[3]));
    }

    /** Full-bleed art on a transparent canvas, shrunk to the adaptive safe-ish area. */
    static BufferedImage foreground(BufferedImage art, int size) {
        BufferedImage out = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = out.createGraphics();
        hint(g);
        int draw = (int) Math.round(size * FG_SCALE);
        int off = (size - draw) / 2;
        g.drawImage(scale(art, draw, draw), off, off, null);
        g.dispose();
        return out;
    }

    /** Art composited over the sampled backdrop, i.e. what an adaptive launcher renders. */
    static BufferedImage composite(BufferedImage art, Color bg, int size, double fraction) {
        BufferedImage out = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = out.createGraphics();
        hint(g);
        g.setColor(bg);
        g.fillRect(0, 0, size, size);
        int draw = (int) Math.round(size * fraction);
        g.drawImage(scale(art, draw, draw), (size - draw) / 2, (size - draw) / 2, null);
        g.dispose();
        return out;
    }

    /** Art clipped to a rounded square (radius fraction >= 0.5 gives a circle). */
    static BufferedImage rounded(BufferedImage art, int size, double radiusFraction) {
        BufferedImage out = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = out.createGraphics();
        hint(g);
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(0, 0, size, size);
        g.setComposite(AlphaComposite.SrcOver);
        double arc = size * Math.min(1.0, radiusFraction * 2.0);
        var shape = radiusFraction >= 0.5
            ? new Ellipse2D.Double(0, 0, size, size)
            : new RoundRectangle2D.Double(0, 0, size, size, arc, arc);
        g.setClip(shape);
        g.drawImage(scale(art, size, size), 0, 0, null);
        g.dispose();
        return out;
    }

    static BufferedImage opaque(BufferedImage img) {
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = out.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, out.getWidth(), out.getHeight());
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return out;
    }

    /** Step down by halves before the final bicubic pass; direct bicubic shrinks alias badly. */
    static BufferedImage scale(BufferedImage src, int tw, int th) {
        BufferedImage cur = src;
        int w = cur.getWidth(), h = cur.getHeight();
        while (w / 2 >= tw && h / 2 >= th) {
            int nw = Math.max(tw, w / 2), nh = Math.max(th, h / 2);
            BufferedImage next = new BufferedImage(nw, nh, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = next.createGraphics();
            hint(g);
            g.drawImage(cur, 0, 0, nw, nh, null);
            g.dispose();
            cur = next;
            w = nw;
            h = nh;
        }
        if (w == tw && h == th) return cur;
        BufferedImage out = new BufferedImage(tw, th, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = out.createGraphics();
        hint(g);
        g.drawImage(cur, 0, 0, tw, th, null);
        g.dispose();
        return out;
    }

    static void hint(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }

    static void writePng(BufferedImage img, File f) throws Exception {
        f.getParentFile().mkdirs();
        if (!ImageIO.write(img, "png", f)) throw new IllegalStateException("no png writer for " + f);
    }

    static void writeAdaptiveXml(File f) throws Exception {
        try (PrintWriter p = new PrintWriter(f, StandardCharsets.UTF_8)) {
            p.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
            p.println("<adaptive-icon xmlns:android=\"http://schemas.android.com/apk/res/android\">");
            p.println("    <background android:drawable=\"@color/ic_launcher_background\" />");
            p.println("    <foreground android:drawable=\"@mipmap/ic_launcher_foreground\" />");
            p.println("</adaptive-icon>");
        }
    }

    static void writeColor(File f, String hex) throws Exception {
        f.getParentFile().mkdirs();
        try (PrintWriter p = new PrintWriter(f, StandardCharsets.UTF_8)) {
            p.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
            p.println("<resources>");
            p.println("    <!-- Sampled from the artwork's own backdrop by tools/IconGen.java -->");
            p.println("    <color name=\"ic_launcher_background\">" + hex + "</color>");
            p.println("</resources>");
        }
    }

    static void writeCatalog(File f) throws Exception {
        try (PrintWriter p = new PrintWriter(f, StandardCharsets.UTF_8)) {
            p.println("{");
            p.println("  \"info\" : { \"author\" : \"xcode\", \"version\" : 1 }");
            p.println("}");
        }
    }

    /** Xcode 14+ single-size iOS app icon. */
    static void writeAppIconContents(File f) throws Exception {
        try (PrintWriter p = new PrintWriter(f, StandardCharsets.UTF_8)) {
            p.println("{");
            p.println("  \"images\" : [");
            p.println("    {");
            p.println("      \"filename\" : \"AppIcon-1024.png\",");
            p.println("      \"idiom\" : \"universal\",");
            p.println("      \"platform\" : \"ios\",");
            p.println("      \"size\" : \"1024x1024\"");
            p.println("    }");
            p.println("  ],");
            p.println("  \"info\" : { \"author\" : \"xcode\", \"version\" : 1 }");
            p.println("}");
        }
    }
}
