/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

/**
 *
 * @author subwiz
 */
public class OS {
    private OS() {}
    
    public static boolean isMac() {
        final String os = System.getProperty("os.name").toLowerCase();
        if(os.indexOf("mac") != -1) {
            return true;
        }
        return false;
    }
    
    public static boolean isWindows() {
        final String os = System.getProperty("os.name").toLowerCase();
        if(os.indexOf("windows") != -1) {
            return true;
        }
        return false;
    }
    
    public static boolean isUnix() {
        final String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);
    }
    
    public static boolean isSolaris() {
        final String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf("sunos") >= 0);
    }
}
