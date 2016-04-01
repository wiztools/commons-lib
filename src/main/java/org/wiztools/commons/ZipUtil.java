/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 *
 * @author subwiz
 */
public final class ZipUtil {
    private ZipUtil(){}

    public static void unzip(final File input, final File outputDir) throws IOException{
        if(!outputDir.isDirectory()){
            throw new IllegalArgumentException(
                    "Output directory does not exist; or, is not a directory.");
        }
        
        try(ZipFile zf = new ZipFile(input)) {
            
            Enumeration<? extends ZipEntry> entries = zf.entries();
            
            while(entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                final String name = entry.getName();
                if(entry.isDirectory()){
                    File f = new File(outputDir, name);
                    if(!f.mkdirs()){
                        throw new IOException("Unable to create directory: "
                                + f.getAbsolutePath());
                    }
                }
                else { // Entry is file
                    File f = new File(outputDir, name);
                    try(
                            OutputStream os = new BufferedOutputStream(
                                new FileOutputStream(f));
                            InputStream zis = zf.getInputStream(entry);
                            ) {
                        byte[] buf = new byte[1024*8];
                        int count;
                        while((count=zis.read(buf)) != -1){
                            os.write(buf, 0, count);
                        }
                    }
                }
            }
        }
    }
}
