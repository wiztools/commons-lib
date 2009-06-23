package org.wiztools.commons;

import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author subwiz
 */
public final class RandomUtil {
    // Do not allow outsiders to instantiate this class:
    private RandomUtil(){}

    private static final char[] CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    public static final int STRING_DEFAULT_LENGTH = 4;

    static String getRandomStr(){
        return getRandomStr(STRING_DEFAULT_LENGTH);
    }

    static String getRandomStr(int len){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            Random r = new SecureRandom();
            int rand = r.nextInt(CHARS.length);
            sb.append(CHARS[rand]);
        }
        return sb.toString();
    }
}
