/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package org.wiztools.commons;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author subhash
 */
public final class RotN {
    private RotN() {}

    private static final char[] lookup = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private static interface Emitter {
        void emit(char c1, char c2);
    }

    private static void map(final int n, final Emitter emitter) {
        if(n < 1 || n > 25)
            throw new IllegalArgumentException("Value of N should be between 1 and 26");

        for(int i=0, j=n; i<lookup.length; i++,j++) {
            if(j == lookup.length)
                j = 0;
            emitter.emit(lookup[i], lookup[j]);
        }
    }

    private static Map<Character, Character> getCipherMap(final int n) {
        final Map<Character, Character> out = new HashMap<Character, Character>();
        Emitter emitter = new Emitter() {
            @Override
            public void emit(char c1, char c2) {
                out.put(c1, c2);
            }
        };
        map(n, emitter);
        return out;
    }

    private static Map<Character, Character> getDeCipherMap(final int n) {
        final Map<Character, Character> out = new HashMap<Character, Character>();
        Emitter emitter = new Emitter() {
            @Override
            public void emit(char c1, char c2) {
                out.put(c2, c1);
            }
        };
        map(n, emitter);
        return out;
    }

    private static String process(final String inString,
            final Map<Character, Character> map) throws IllegalArgumentException {
        char[] arr = inString.toCharArray();
        StringBuilder sb = new StringBuilder(arr.length);
        for(char c: arr) {
            Character out = map.get(c);
            if(out == null) {
                sb.append(c);
            }
            else {
                if(Character.isUpperCase(c))
                    sb.append(Character.toUpperCase(out));
                else
                    sb.append(out);
            }
        }
        return sb.toString();
    }

    public static String cipher(final int n, final String inString) throws IllegalArgumentException {
        return process(inString, getCipherMap(n));
    }

    public static String deCipher(final int n, final String inString) throws IllegalArgumentException {
        return process(inString, getDeCipherMap(n));
    }
}
