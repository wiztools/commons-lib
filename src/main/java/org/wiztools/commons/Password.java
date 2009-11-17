package org.wiztools.commons;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Convenience class for common hashing functionality.
 * @author subwiz
 */
public final class Password {

    private Password(){}

    private static String hash(final String password, final String algo){
        byte[] inBytes = password.getBytes(CommonCharset.UTF_8);
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

    public static String md5(final String password){
        return hash(password, HashAlgorithm.MD5);
    }

    public static String sha256(final String password){
        return hash(password, HashAlgorithm.SHA_256);
    }

    public static String sha512(final String password){
        return hash(password, HashAlgorithm.SHA_512);
    }
}
