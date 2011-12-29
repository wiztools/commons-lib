/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package org.wiztools.commons;

import java.io.IOException;

/**
 *
 * @author subwiz
 */
public class ToStringBuilder {
    
    private final StringBuilder sb = new StringBuilder();

    public ToStringBuilder append(Object obj) {
        if(sb.length() != 0) { // already has content
            sb.append("; ");
        }
        sb.append(obj);
        return this;
    }

    @Override
    public String toString() {
        return sb.insert(0, "{").append("}").toString();
    }
}
