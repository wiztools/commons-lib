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

    /**
     * Append the obj for the purpose of building the final toString representation.
     * @param obj The object to be appended.
     * @return Returns this object instance for chaining purposes.
     */
    public ToStringBuilder append(Object obj) {
        addSeparator();
        sb.append(obj);
        return this;
    }
    
    /**
     * 
     * @param name The name of the object to be appended.
     * @param obj The object to be appended.
     * @return Returns this object instance for chaining purposes.
     */
    public ToStringBuilder append(String name, Object obj) {
        addSeparator();
        sb.append(name).append("=").append(obj);
        return this;
    }

    /**
     * 
     * @return Return the generated string representation. 
     */
    @Override
    public String toString() {
        return sb.insert(0, "{").append("}").toString();
    }
}
