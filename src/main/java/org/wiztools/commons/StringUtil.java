package org.wiztools.commons;

import java.util.Collection;

/**
 *
 * @author subwiz
 */
public final class StringUtil {

    // Don't allow initialization of this class:
    private StringUtil(){}

    /**
     * Checks if the String is null, or an empty string.
     * @param str The string to check.
     * @return Return value of the validation.
     */
    public static boolean isStrEmpty(final String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @param str The string to verify for null content.
     * @return Returns null string if null is encountered, else the same reference to the string.
     */
    public static String getNullStrIfNull(final String str) {
        return str == null ? "" : str;
    }

    /**
     * A method similar to PHP's implode() function (http://php.net/implode)
     * @param glue The String to glue pieces together.
     * @param pieces An array of String which needs to be glued.
     * @return Returns the concatenated string.
     */
    public static String implode(final String glue, final String[] pieces){
        StringBuilder sb = new StringBuilder();
        final int last = pieces.length;
        int count = 1;
        for(String str: pieces){
            sb.append(str);
            if(count<last && glue != null){
                sb.append(glue);
            }
            count++;
        }
        return sb.toString();
    }

    /**
     * A method similar to PHP's implode() function (http://php.net/implode)
     * @param pieces An array of String which needs to be glued.
     * @return Returns the concatenated string.
     */
    public static String implode(final String[] pieces){
        return implode(null, pieces);
    }

    // An empty String array used for toArray() operation
    public final static String[] STRING_ARRAY = new String[]{};

    /**
     * A method similar to PHP's implode() function (http://php.net/implode)
     * @param glue The String to glue pieces together.
     * @param pieces A collection of String which needs to be glued.
     * @return Returns the concatenated string.
     */
    public static String implode(final String glue, final Collection<String> pieces){
        return implode(glue, pieces.toArray(STRING_ARRAY));
    }

    /**
     * A method similar to PHP's implode() function (http://php.net/implode)
     * @param pieces A collection of String which needs to be glued.
     * @return Returns the concatenated string.
     */
    public static String implode(final Collection<String> pieces){
        return implode(pieces.toArray(STRING_ARRAY));
    }
}
