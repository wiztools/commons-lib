/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package org.wiztools.commons;

/**
 * Builder class to generate the toString() output.
 * @author subwiz
 */
public class ToStringBuilder {
    
    private final StringBuilder sb = new StringBuilder();
    
    private void addSeparator() {
        if(sb.length() != 0) { // already has content
            sb.append("; ");
        }
    }

    public ToStringBuilder append(Object obj) {
        addSeparator();
        sb.append(obj);
        return this;
    }
    
    public ToStringBuilder append(String name, Object obj) {
        addSeparator();
        sb.append(name).append("=").append(obj);
        return this;
    }

    @Override
    public String toString() {
        return sb.insert(0, "{").append("}").toString();
    }
}
