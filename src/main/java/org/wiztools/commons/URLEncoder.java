/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.io.UnsupportedEncodingException;

/**
 * Class provides encode and decode methods with UTF-8 encoding.
 * @author subwiz
 */
public class URLEncoder {
    private URLEncoder() {}
    
    private static final String utf8 = Charsets.UTF_8.name();
    
    public static String encode(String inStr) {
        try {
            return java.net.URLEncoder.encode(inStr, utf8);
        }
        catch(UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static String decode(String inStr) {
        try {
            return java.net.URLDecoder.decode(inStr, utf8);
        }
        catch(UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
