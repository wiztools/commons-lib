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
public class BooleanUtil {
    private BooleanUtil() {}

    /**
     * If the boolean value is true, returns 1, otherwise 0.
     * @param b
     * @return 1 for true, otherwise 0
     */
    public static short asNumber(final boolean b) {
        return b? (short)1: (short)0;
    }
}
