package org.wiztools.commons;

/**
 *
 * @author subwiz
 */
public final class HexEncodeUtil {

    final static String pseudo[] = {"0", "1", "2",
            "3", "4", "5", "6", "7", "8",
            "9", "a", "b", "c", "d", "e",
            "f"};

    private HexEncodeUtil(){}

    static String bytesToHex(byte input[]) {
        if (input == null || input.length <= 0) {
            return null;
        }

        final StringBuilder out = new StringBuilder(input.length * 2);

        for(int i=0; i<input.length; i++) {
            byte ch = (byte) (input[i] & 0xF0); // Strip off high nibble
            ch = (byte) (ch >>> 4);
            // shift the bits down
            ch = (byte) (ch & 0x0F);
            // must do this is high order bit is on!
            out.append(pseudo[(int) ch]); // convert the nibble to a String Character
            ch = (byte) (input[i] & 0x0F); // Strip off low nibble
            out.append(pseudo[(int) ch]); // convert the nibble to a String Character
        }

        return out.toString();
    }
}
