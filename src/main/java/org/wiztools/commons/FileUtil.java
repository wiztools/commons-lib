package org.wiztools.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Common functions using the java.io.File object.
 * @author subwiz
 */
public final class FileUtil {
    private FileUtil(){}

    /**
     * Returns the content of the file as a String
     * @param f File to read the content from
     * @param charset The charset to use to read the content.
     * @return Content of the file as a String.
     * @throws IOException
     **/
    public static String getContentAsString(final File f,
            final Charset charset)
                throws IOException{
        InputStream is = null;
        try {
            is = new FileInputStream(f);
            return StreamUtil.inputStream2String(is, charset);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * Read the contents of the file as a byte[]
     * @param f The file to read the content from.
     * @return The content of the file as byte[].
     * @throws IOException
     */
    public static byte[] getContentAsBytes(final File f)
            throws IOException{
        return StreamUtil.inputStream2Bytes(new FileInputStream(f));
    }

    /**
     * Returns the mime-type of the file. Returns "content/unknown" when
     * VM is not able to determine type.
     * @param f File for which mime-type needs to be determined.
     * @return Mime-type as a String.
     */
    public static String getMimeType(File f) {
        String type = null;
        URLConnection uc = null;
        try {
            URL u = f.toURI().toURL();
            uc = u.openConnection();
            type = uc.getContentType();
        } catch (Exception e) {
            // Do nothing!
            e.printStackTrace();
        } finally {
            if (uc != null) {
                // No method like uc.close() !!
            }
        }
        return type;
    }

    /**
     * Writes the provided String to the file using the provided charset encoding.
     * @param f The file the write the String to.
     * @param content The content String to write.
     * @param charset The charset encoding to use when writing.
     * @throws IOException
     */
    public static void writeString(final File f,
            final String content,
            final Charset charset)
                throws IOException{
        PrintWriter w = null;
        try{
            w = new PrintWriter(f, charset.name());
            w.print(content);
        }
        finally{
            w.close();
        }
    }

    /**
     * Writes a byte[] to a file.
     * @param f The file to write the byte[].
     * @param bytes The content to write.
     * @throws IOException
     */
    public static void writeBytes(final File f,
            final byte[] bytes)
                throws IOException{
        OutputStream os = null;
        try{
            os = new FileOutputStream(f);
            os.write(bytes, 0, bytes.length);
        }
        finally{
            if(os != null){
                os.close();
            }
        }
    }
}
