package org.wiztools.commons;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.MalformedInputException;

/**
 *
 * @author subwiz
 */
public final class StreamUtil {
    private StreamUtil(){}

    private static CharBuffer decodeHelper(byte[] byteArray, int numberOfBytes, java.nio.charset.Charset charset) throws IOException {
        CharsetDecoder decoder = charset.newDecoder();
        CharBuffer charBuffer = null;
        try {
            charBuffer = decoder.decode(ByteBuffer.wrap(byteArray, 0,
                    numberOfBytes));
        } catch (MalformedInputException ex) {
            charBuffer = null;
        }
        return charBuffer;


    }

    public static String inputStream2String(final InputStream in,
            final java.nio.charset.Charset charset) throws IOException {
        if (in == null) {
            return "";
        }
        StringBuilder out = new StringBuilder();
        byte[] b = new byte[4096];
        byte[] savedBytes = new byte[1];
        boolean hasSavedBytes = false;
        CharsetDecoder decoder = charset.newDecoder();
        for (int n; (n = in.read(b)) != -1;) {
            if (hasSavedBytes) {
                byte[] bTmp = new byte[savedBytes.length + b.length];
                System.arraycopy(savedBytes, 0, bTmp, 0,
                        savedBytes.length);
                System.arraycopy(b, 0, bTmp, savedBytes.length, b.length);
                b = bTmp;
                hasSavedBytes = false;
                n = n + savedBytes.length;
            }

            CharBuffer charBuffer = decodeHelper(b, n, charset);
            if (charBuffer == null) {
                int nrOfChars = 0;
                while (charBuffer == null) {
                    nrOfChars++;
                    charBuffer = decodeHelper(b, n - nrOfChars, charset);
                    if (nrOfChars > 10 && nrOfChars < n) {
                        try {
                            charBuffer = decoder.decode(ByteBuffer.wrap(b,
                                    0, n));
                        } catch (MalformedInputException ex) {
                            throw new IOException(
                                    "File not in supported encoding (" +
                                    charset.displayName() + ")", ex);
                        }
                    }
                }
                savedBytes = new byte[nrOfChars];
                hasSavedBytes = true;
                for (int i = 0; i < nrOfChars; i++) {
                    savedBytes[i] = b[n - nrOfChars + i];
                }
            }

            charBuffer.rewind(); // Bring the buffer's pointer to 0
            out.append(charBuffer.toString());
        }
        if (hasSavedBytes) {
            try {
                CharBuffer charBuffer = decoder.decode(ByteBuffer.wrap(savedBytes, 0, savedBytes.length));
            } catch (MalformedInputException ex) {
                throw new IOException(
                        "File not in supported encoding (" + charset.displayName() + ")",
                        ex);
            }
        }
        return out.toString();
    }

    public static byte[] inputStream2Bytes(final InputStream is) throws IOException{
        try{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024*8];
            int len = -1;
            while((len = is.read(buf))>0){
                baos.write(buf, 0, len);
            }
            return baos.toByteArray(); // baos doesn't need close!
        }
        finally{
            is.close();
        }
    }
}
