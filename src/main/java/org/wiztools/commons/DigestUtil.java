package org.wiztools.commons;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Convenience class for common hashing functionality.
 * @author subwiz
 */
public final class DigestUtil {

    private DigestUtil(){}

    public static String digest(final byte[] inBytes, final String algo){
        try{
            MessageDigest md = MessageDigest.getInstance(algo);
            md.reset();
            md.update(inBytes);
            byte[] outBytes = md.digest();
            return HexEncodeUtil.bytesToHex(outBytes);
        }
        catch(NoSuchAlgorithmException ex){
            // Will not come here!
            throw new RuntimeException(ex);
        }
    }

    public static String md5hex(final String str){
        return digest(
                str.getBytes(Charsets.UTF_8),
                DigestAlgorithm.MD5);
    }

    public static String md5hex(final byte[] bytes){
        return digest(
                bytes,
                DigestAlgorithm.MD5);
    }

    public static String sha1hex(final String str){
        return digest(
                str.getBytes(Charsets.UTF_8),
                DigestAlgorithm.SHA_1);
    }

    public static String sha1hex(final byte[] bytes){
        return digest(
                bytes,
                DigestAlgorithm.SHA_1);
    }

    public static String sha256hex(final String str){
        return digest(
                str.getBytes(Charsets.UTF_8),
                DigestAlgorithm.SHA_256);
    }

    public static String sha256hex(final byte[] bytes){
        return digest(
                bytes,
                DigestAlgorithm.SHA_256);
    }

    public static String sha512hex(final String str){
        return digest(
                str.getBytes(Charsets.UTF_8),
                DigestAlgorithm.SHA_512);
    }

    public static String sha512hex(final byte[] bytes){
        return digest(
                bytes,
                DigestAlgorithm.SHA_512);
    }
}
