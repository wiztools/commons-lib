/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * JavaScript functions in Java. Internally calls Rhino's implementation of the
 * function calls.
 * @author subhash
 */
public class JavaScript {
    private JavaScript() {}

    private static final ScriptEngine jsEngine;
    static {
        jsEngine = new ScriptEngineManager().getEngineByName("JavaScript");
    }

    private static String toUpperCaseEncodedChars(final String inStr) {
        int lastPercentPosition = -3; // 0- (-3 ) > 2: ensures the first character is not uppercased accidently
        final char[] c = inStr.toCharArray();
        char[] cOut = new char[c.length];
        for(int i=0; i< c.length; i++) {
            if(c[i] == '%') {
                lastPercentPosition = i;
            }
            final int diff = i - lastPercentPosition;
            if(diff == 1 || diff == 2) {
                cOut[i] = Character.toUpperCase(c[i]);
            }
            else {
                cOut[i] = c[i];
            }
        }
        return new String(cOut);
    }

    public static String escape(final String str) {
        try{
            return (String) ((Invocable) jsEngine).invokeFunction("escape", str);
        }
        catch(ScriptException ex) {
            throw new RuntimeException(ex);
        }
        catch(NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String unescape(final String str) {
        try{
            return (String) ((Invocable) jsEngine).invokeFunction("unescape", str);
        }
        catch(ScriptException ex) {
            throw new RuntimeException(ex);
        }
        catch(NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String encodeURI(final String str) {
        try{
            final String out = (String) ((Invocable) jsEngine).invokeFunction("encodeURI", str);
            return toUpperCaseEncodedChars(out);
        }
        catch(ScriptException ex) {
            throw new RuntimeException(ex);
        }
        catch(NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String decodeURI(final String str) {
        try{
            return (String) ((Invocable) jsEngine).invokeFunction("decodeURI", str);
        }
        catch(ScriptException ex) {
            throw new RuntimeException(ex);
        }
        catch(NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String encodeURIComponent(final String str) {
        try{
            final String out = (String) ((Invocable) jsEngine).invokeFunction("encodeURIComponent", str);
            return toUpperCaseEncodedChars(out);
        }
        catch(ScriptException ex) {
            throw new RuntimeException(ex);
        }
        catch(NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 
     * @param str
     * @return
     */
    public static String decodeURIComponent(final String str) {
        try{
            return (String) ((Invocable) jsEngine).invokeFunction("decodeURIComponent", str);
        }
        catch(ScriptException ex) {
            throw new RuntimeException(ex);
        }
        catch(NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }
}
