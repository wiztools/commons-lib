/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

/**
 * Convenience method to encode XML pre-defined entity characters.
 * @author subwiz
 */
public final class XmlEntityEncode {
    private XmlEntityEncode(){}

    /**
     * Converts XML special characters like &lt; to corresponding encoded value &amp;lt;.
     * @param input
     * @return String which can be embeded safely inside XML document.
     */
    public static String encode(final String input){
        final StringBuilder sb = new StringBuilder();
        for(final char c: input.toCharArray()) {
            switch(c) {
                case '&':
                    sb.append("&amp;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                case '"':
                    sb.append("&quot;");
                    break;
                default:
                    sb.append(c);
            }
        }

        return sb.toString();
    }
}
