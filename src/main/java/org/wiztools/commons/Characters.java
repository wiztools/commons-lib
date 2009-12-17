package org.wiztools.commons;

/**
 *
 * @author subhash
 */
public interface Characters {
    // Base64
    public char[] BASE64 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+/".toCharArray();
    public char[] BASE64_URL = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".toCharArray();
    public char[] BASE64_REGEXP = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!-".toCharArray();
    public char[] BASE64_FILENAME = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+-".toCharArray();

    // Base62 characters:
    public char[] BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    // Base58 characters do not have confusing chars: 0, O, I, l
    // Good for print media.
    public char[] BASE58 = "123456789abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ".toCharArray();

    // Numbers
    public char[] NUMBERS = "0123456789".toCharArray();

    // Alphabets
    public char[] ALPHABETS_LOWERCASE = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public char[] ALPHABETS_UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public char[] ALPHABETS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    // Special chars:
    // All the special chars available in my US-English keyboard:
    public char[] SPECIAL = "`~!@#$%^&*()-_+=|\\{}[]:;\"'<>,./?".toCharArray();
}
