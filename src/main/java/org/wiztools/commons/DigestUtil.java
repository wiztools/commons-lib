package org.wiztools.commons;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Convenience class for common hashing functionality.
 * @author subwiz
 */
public final class DigestUtil {

    private DigestUtil(){}

    private static String digest(final byte[] inBytes, final String algo){
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
                str.getBytes(CommonCharset.UTF_8),
                HashAlgorithm.MD5);
    }

    public static String md5hex(final byte[] bytes){
        return digest(
                bytes,
                HashAlgorithm.MD5);
    }

    public static String sha1hex(final String str){
        return digest(
                str.getBytes(CommonCharset.UTF_8),
                HashAlgorithm.SHA_1);
    }

    public static String sha1hex(final byte[] bytes){
        return digest(
                bytes,
                HashAlgorithm.SHA_1);
    }

    public static String sha256hex(final String str){
        return digest(
                str.getBytes(CommonCharset.UTF_8),
                HashAlgorithm.SHA_256);
    }

    public static String sha256hex(final byte[] bytes){
        return digest(
                bytes,
                HashAlgorithm.SHA_256);
    }

    public static String sha512hex(final String str){
        return digest(
                str.getBytes(CommonCharset.UTF_8),
                HashAlgorithm.SHA_512);
    }

    public static String sha512hex(final byte[] bytes){
        return digest(
                bytes,
                HashAlgorithm.SHA_512);
    }
}
