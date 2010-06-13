/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package org.wiztools.commons;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import static org.wiztools.commons.Characters.BASE58;

/**
 * Class to compute the Base58 value of a long counter.
 * @author subwiz
 */
public class Base58Util {
    private final static Map<Character, Long> MAP_BASE58;
    static {
        final Map<Character, Long> base54 = new HashMap<Character, Long>();
        for(long i = 0; i < BASE58.length; i++) {
            base54.put(BASE58[(int)i], i);
        }
        MAP_BASE58 = Collections.unmodifiableMap(base54);
    }

    /**
     * Encodes the given value as a Base58 string.
     * @param value The value to be encoded.
     * @return The encoded value.
     */
    public static String encode(final long value) {
        long val = value;
        if(val < Long.valueOf(BASE58.length)) {
            return String.valueOf(BASE58[(int)val]);
        }

        final LinkedList<Long> reminderList = new LinkedList<Long>();
        while(true) {
            final long reminder = val % BASE58.length;
            reminderList.addFirst(reminder);

            val = val / BASE58.length;

            if(val < BASE58.length) {
                reminderList.addFirst(val);
                break;
            }
        }

        final StringBuilder sb = new StringBuilder();
        for(long l: reminderList) {
            sb.append(BASE58[(int)l]);
        }
        return sb.toString();
    }

    /**
     * Decodes a Base58 string to its corresponding decimal equivalent.
     * @param value The Base58 encoded string.
     * @return The long representation of the encoded string.
     * @throws IllegalArgumentException When invalid characters are encountered.
     */
    public static long decode(final String value) {
        final String val = value.trim();
        final char[] chars = val.toCharArray();
        ArrayUtil.reverse(chars);
        long result = 0;
        long mul = 1L;
        for(int i = 0; i < chars.length ; i++){
            if(MAP_BASE58.get(chars[i]) == null) {
                throw new IllegalArgumentException("Invalid character encountered: " + chars[i]);
            }
            final long v = MAP_BASE58.get(chars[i]);

            // Compute:
            result += v * mul;

            // update mul:
            mul *= BASE58.length;
        }
        return result;
    }
}
