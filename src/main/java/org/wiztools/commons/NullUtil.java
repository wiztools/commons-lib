/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

/**
 *
 * @author subhash
 */
public class NullUtil {
    private NullUtil() {}

    public static boolean isAnyNull(Object ... l) {
        for(Object o: l) {
            if(o == null) return true;
        }
        return false;
    }

    public static boolean isAllNull(Object ... l) {
        for(Object o: l) {
            if(o != null) return false;
        }
        return true;
    }
}
