package org.wiztools.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author subwiz
 */
public class FileUtil {
    private FileUtil(){}

    public String getContentAsString(final File f,
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
}
