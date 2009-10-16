package org.wiztools.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author subwiz
 */
public class FileUtil {
    private FileUtil(){}

    public static String getContentAsString(final File f,
            final java.nio.charset.Charset charset)
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
}
