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

    public static final int STRING_DEFAULT_LENGTH = 4;

    /**
     * 
     * @return Returns a random string consisting of [a-zA-Z0-9] of length 4 characters.
     */
    public static String getRandomStr(){
        return getRandomStr(STRING_DEFAULT_LENGTH);
    }

    /**
     *
     * @param len The length of the random string to generate.
     * @return Returns a random string consisting of [a-zA-Z0-9] of length <tt>len</tt> characters.
     */
    public static String getRandomStr(int len){
        return getRandomStr(len, Characters.BASE62);
    }

    /**
     * Generate random string from specified characters.
     * @param len of the random string
     * @param arr Randomize characters from this array
     * @return random characters of length len
     */
    public static String getRandomStr(int len, char[] arr){
        if(len < 1){
            throw new IllegalArgumentException("The parameter value should be greater than 0.");
        }
        if(arr.length < 2){
            throw new IllegalArgumentException("Character array should have atleast length 2.");
        }
        
        final StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            Random r = new SecureRandom();
            int rand = r.nextInt(arr.length);
            sb.append(arr[rand]);
        }
        return sb.toString();
    }
}
