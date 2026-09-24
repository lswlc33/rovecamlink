"""Build a canned DCIM tree for the UI test mode.

Layout mirrors what the S7PRO serves: `<root>/<yyyyMMddHHmmss>/<name>.JPG|MP4`
with a same-stem `.THM` beside each file. The thumbnails are the real thing —
distinct colours, big numerals, a date and a filename — so a glance at the
gallery says whether a cell rendered the right picture, not just *a* picture.

The entries named `.MP4` hold genuinely playable H.264, not a JPEG with a video
extension. The gallery only needs a still to draw, but the *viewer* hands the
file to ExoPlayer, and a JPEG under a `.MP4` name is rejected the moment it is
opened — so a tree of renamed images could not exercise playback at all. The
clips are two seconds of colour with the same numeral burnt in, which is enough
to tell which clip is playing without being worth bytes.

Both halves write real sizes, and `UiTestDevice.files()` repeats those numbers
byte for byte: `download()` compares the written length against the declared
`sizeBytes` and fails the transfer on a mismatch, so a made-up figure here would
make every file in this mode un-openable.
"""

import os
import subprocess
import sys

from PIL import Image, ImageDraw, ImageFont

OUT = os.path.dirname(os.path.abspath(__file__))
DCIM = os.path.join(OUT, "DCIM")

# name, kind, stamp, headline, scene colours (top, bottom)
ITEMS = [
    ("2026092114302200.MP4", "VIDEO", "20260921143022", "1", ((0x1B, 0x4F, 0x72), (0x2E, 0x86, 0xC1))),
    ("2026092114315500.JPG", "PHOTO", "20260921143155", "2", ((0x1E, 0x6B, 0x3A), (0x4C, 0xAF, 0x50))),
    ("2026092118041100.MP4", "VIDEO", "20260921180411", "3", ((0x6A, 0x1B, 0x9A), (0xAB, 0x47, 0xBC))),
    ("2026092209120300.JPG", "PHOTO", "20260922091203", "4", ((0xB7, 0x1C, 0x1C), (0xE5, 0x39, 0x35))),
    ("2026092209121900.JPG", "PHOTO", "20260922091219", "5", ((0xB9, 0x5A, 0x00), (0xFB, 0x8C, 0x00))),
    ("2026092219384700.MP4", "VIDEO", "20260922193847", "6", ((0x00, 0x69, 0x5C), (0x00, 0x89, 0x7B))),
]

THUMB_W, THUMB_H = 320, 320  # a square, matching the gallery's 1:1 cells

CLIP_SECONDS = 2
CLIP_FPS = 24
CLIP_SIZE = "480x480"


def font(size):
    for name in ("arialbd.ttf", "arial.ttf", "DejaVuSans-Bold.ttf", "DejaVuSans.ttf"):
        try:
            return ImageFont.truetype(name, size)
        except OSError:
            continue
    return ImageFont.load_default()


def make_thumb(headline, stamp, name, kinds, size):
    """A gradient card with the numeral, the date and the file name."""
    top, bottom = kinds
    img = Image.new("RGB", size, top)
    d = ImageDraw.Draw(img)
    w, h = size

    # Vertical gradient, one row at a time — small enough to be free.
    for y in range(h):
        t = y / max(1, h - 1)
        d.line(
            [(0, y), (w, y)],
            fill=(
                int(top[0] + (bottom[0] - top[0]) * t),
                int(top[1] + (bottom[1] - top[1]) * t),
                int(top[2] + (bottom[2] - top[2]) * t),
            ),
        )

    # A darker plate so the white text never fights the gradient.
    plate = (0, 0, 0, 90)
    overlay = Image.new("RGBA", size, (0, 0, 0, 0))
    od = ImageDraw.Draw(overlay)
    od.rectangle([0, int(h * 0.62), w, h], fill=plate)
    img = Image.alpha_composite(img.convert("RGBA"), overlay).convert("RGB")
    d = ImageDraw.Draw(img)

    big = font(int(w * 0.52))
    bb = d.textbbox((0, 0), headline, font=big)
    d.text(((w - (bb[2] - bb[0])) / 2 - bb[0], h * 0.06 - bb[1]), headline, font=big, fill="white")

    small = font(int(w * 0.088))
    sub = f"{stamp[:4]}-{stamp[4:6]}-{stamp[6:8]}  {stamp[8:10]}:{stamp[10:12]}"
    bb = d.textbbox((0, 0), sub, font=small)
    d.text(((w - (bb[2] - bb[0])) / 2 - bb[0], h * 0.66), sub, font=small, fill="white")

    tiny = font(int(w * 0.07))
    bb = d.textbbox((0, 0), name, font=tiny)
    d.text(((w - (bb[2] - bb[0])) / 2 - bb[0], h * 0.76), name, font=tiny, fill=(235, 235, 235))

    # A play badge on clips, so a video cell differs from a photo cell at a glance.
    if name.upper().endswith(".MP4"):
        r = int(w * 0.075)
        cx, cy = int(w * 0.5), int(h * 0.5)
        d.ellipse([cx - r, cy - r, cx + r, cy + r], fill=(255, 255, 255, 220))
        d.polygon(
            [(cx - r * 0.34, cy - r * 0.5), (cx - r * 0.34, cy + r * 0.5), (cx + r * 0.52, cy)],
            fill=(20, 20, 20),
        )
    return img


def ffmpeg_exe():
    """The bundled ffmpeg if imageio-ffmpeg is around, else whatever is on PATH."""
    try:
        import imageio_ffmpeg

        return imageio_ffmpeg.get_ffmpeg_exe()
    except ImportError:
        return "ffmpeg"


def make_clip(dest, headline, kinds):
    """Two seconds of H.264 with the numeral burnt into every frame.

    Baseline profile + yuv420p so the file is decodable on any Android device the
    app might land on; `+faststart` so ExoPlayer can start without the whole thing.
    """
    top, bottom = kinds
    colour = "%02X%02X%02X" % top
    # drawtext wants a font file. The Windows path is the reliable one here, but a
    # missing font must not sink the whole tree — the clip is valid without a glyph.
    font = "C\\:/Windows/Fonts/arialbd.ttf"
    vf = (
        f"drawtext=fontfile='{font}':text='{headline}':fontcolor=white"
        f":fontsize=220:x=(w-text_w)/2:y=(h-text_h)/2"
    )
    cmd = [
        ffmpeg_exe(), "-y", "-loglevel", "error",
        "-f", "lavfi",
        "-i", f"color=c=0x{colour}:s={CLIP_SIZE}:r={CLIP_FPS}:d={CLIP_SECONDS}",
        "-vf", vf,
        "-c:v", "libx264", "-profile:v", "baseline", "-level", "3.0",
        "-pix_fmt", "yuv420p",
        "-movflags", "+faststart",
        dest,
    ]
    proc = subprocess.run(cmd, capture_output=True, text=True)
    if proc.returncode != 0:
        raise RuntimeError(f"ffmpeg failed: {proc.stderr.strip()[:300]}")
    return os.path.getsize(dest)


def main():
    baked = 0
    clips = 0
    for name, kind, stamp, headline, kinds in ITEMS:
        folder = os.path.join(DCIM, stamp)
        os.makedirs(folder, exist_ok=True)
        stem = name.rsplit(".", 1)[0]

        thumb = make_thumb(headline, stamp, name, kinds, (THUMB_W, THUMB_H))
        thumb.save(os.path.join(folder, stem + ".THM"), "JPEG", quality=88)

        dest = os.path.join(folder, name)
        if kind == "VIDEO":
            size = make_clip(dest, headline, kinds)
            clips += 1
            print(f"  {stamp}/{name}  {size:,}B  (+{stem}.THM)")
        else:
            # The original itself, larger, so a preview/download has something real.
            big = make_thumb(headline, stamp, name, kinds, (1080, 1080))
            big.save(dest, "JPEG", quality=82)
            print(f"  {stamp}/{name}  {os.path.getsize(dest):,}B  (+{stem}.THM)")
        baked += 1

    print(f"\n{baked} items in {DCIM} ({clips} playable clips)")

    # The sizes are what `UiTestDevice.files()` declares. Print them in the shape
    # that file wants so the two cannot drift apart unnoticed.
    print("\ndeclare in UiTestDevice.files():")
    for name, _kind, stamp, _headline, _kinds in ITEMS:
        size = os.path.getsize(os.path.join(DCIM, stamp, name))
        print(f'    file("{name}", ..., {size:_}, "{stamp}"),')


if __name__ == "__main__":
    sys.exit(main())
