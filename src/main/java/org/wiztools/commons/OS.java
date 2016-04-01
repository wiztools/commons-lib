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
        return os.contains("mac");
    }
    
    public static boolean isWindows() {
        final String os = System.getProperty("os.name").toLowerCase();
        return os.contains("windows");
    }
    
    public static boolean isUnix() {
        final String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("nix") || os.contains("nux"));
    }
    
    public static boolean isSolaris() {
        final String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("sunos"));
    }
}
