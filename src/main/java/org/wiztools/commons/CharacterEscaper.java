/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package org.wiztools.commons;

import java.util.Arrays;

/**
 * Escapes specified characters in string with a `\' prefix.
 * @author subwiz
 */
public class CharacterEscaper {
    final char[] charsToEscape;

    public CharacterEscaper(String str) {
        this(str.toCharArray());
    }
    
    public CharacterEscaper(char[] charsToEscape) {
        this.charsToEscape = Arrays.copyOf(charsToEscape, charsToEscape.length);
        Arrays.sort(this.charsToEscape);
    }
    
    /**
     * Escape the characters in the given string and return the escaped string.
     * @param str The input string.
     * @return The escaped string.
     */
    public String escape(String str) {
        final StringBuilder sb = new StringBuilder();
        for(char c: str.toCharArray()) {
            if(Arrays.binarySearch(charsToEscape, c) >= 0) {
                sb.append('\\').append(c);
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 
     * @return The characters to escape.
     */
    @Override
    public String toString() {
        return new String(charsToEscape);
    }
}
