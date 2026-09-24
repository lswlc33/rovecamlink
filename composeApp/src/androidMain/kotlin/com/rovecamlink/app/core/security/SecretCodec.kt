package com.rovecamlink.app.core.security

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Base64
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec

/**
 * At-rest protection for the few secrets this app persists — the camera hotspot
 * passphrase and the BLE pairing code. Both grant access to the camera's own
 * network, and both used to sit in `SharedPreferences` in the clear, so an
 * `adb backup` (or any reader of the app-private prefs) handed them over.
 *
 * Encrypts with an AES/GCM key that never leaves the [KeyStore] (`AndroidKeyStore`),
 * which is what lets this stay dependency-free: `androidx.security.security-crypto`
 * would be a new coordinate, and this project's CI resolves only cached artifacts.
 * The key is generated on first use, needs no user auth so a reconnect is silent,
 * and GCM's per-message random IV is carried in the stored string.
 *
 * Storage format: `enc1:<b64 iv>:<b64 ciphertext+tag>`. A value **without** the
 * prefix is treated as legacy plaintext and returned as-is, so prefs written by an
 * older build still read back; the next [encrypt] rewrites them in the new form.
 * A fallback plaintext written after [encrypt] returned null carries [PLAIN_PREFIX]
 * instead, so it is distinguishable from both an encrypted value and an unprefixed
 * legacy one.
 * A value that fails to decrypt (key lost after a restore, corrupt data) reads as
 * `null` — "re-enter the password", never "the app crashed".
 */
internal object SecretCodec {

    private const val KEYSTORE = "AndroidKeyStore"
    private const val ALIAS = "rovcamlink-secret-v1"
    private const val TRANSFORM = "AES/GCM/NoPadding"
    private const val TAG_BITS = 128
    private const val PREFIX = "enc1:"

    /**
     * Marks a value the keystore refused to encrypt, which therefore reaches disk in
     * the clear. Without a marker such a value is indistinguishable from a legacy
     * unprefixed one, so neither [decrypt] nor a later migration could tell them apart.
     * An encrypted value never carries this prefix.
     */
    const val PLAIN_PREFIX = "plain:"

    /** Encrypt [plain], or return null when the keystore is unavailable. */
    fun encrypt(plain: String): String? = runCatching {
        val cipher = Cipher.getInstance(TRANSFORM)
        cipher.init(Cipher.ENCRYPT_MODE, key())
        val body = cipher.doFinal(plain.toByteArray(Charsets.UTF_8))
        buildString {
            append(PREFIX)
            append(Base64.encodeToString(cipher.iv, Base64.NO_WRAP))
            append(':')
            append(Base64.encodeToString(body, Base64.NO_WRAP))
        }
    }.getOrNull()

    /**
     * Wrap [plain] with [PLAIN_PREFIX] for storage, for the [encrypt] == null downgrade.
     * Callers must log the downgrade themselves: a value built here reaches disk in the
     * clear, and only the caller knows which secret it is.
     */
    fun plaintextFallback(plain: String): String = PLAIN_PREFIX + plain

    /** Decrypt a stored value; legacy plaintext and [PLAIN_PREFIX] fallbacks pass through. */
    fun decrypt(stored: String): String? {
        if (stored.startsWith(PLAIN_PREFIX)) return stored.removePrefix(PLAIN_PREFIX)
        if (!stored.startsWith(PREFIX)) return stored
        return runCatching {
            val payload = stored.removePrefix(PREFIX)
            val sep = payload.indexOf(':')
            if (sep <= 0) return@runCatching null
            val iv = Base64.decode(payload.substring(0, sep), Base64.NO_WRAP)
            val body = Base64.decode(payload.substring(sep + 1), Base64.NO_WRAP)
            val cipher = Cipher.getInstance(TRANSFORM)
            cipher.init(Cipher.DECRYPT_MODE, key(), GCMParameterSpec(TAG_BITS, iv))
            String(cipher.doFinal(body), Charsets.UTF_8)
        }.getOrNull()
    }

    private fun key(): SecretKey {
        val ks = KeyStore.getInstance(KEYSTORE).apply { load(null) }
        (ks.getEntry(ALIAS, null) as? KeyStore.SecretKeyEntry)?.let { return it.secretKey }
        val gen = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, KEYSTORE)
        gen.init(
            KeyGenParameterSpec.Builder(
                ALIAS,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT,
            )
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .build(),
        )
        return gen.generateKey()
    }
}
