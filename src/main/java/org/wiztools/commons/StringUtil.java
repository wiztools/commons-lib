package org.wiztools.commons;

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
}
