/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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

        ZipInputStream zis = null;
        try{
            zis = new ZipInputStream(
                    new BufferedInputStream(new FileInputStream(input)));
            ZipEntry entry;
            while((entry=zis.getNextEntry())!=null){
                final String name = entry.getName();
                if(entry.isDirectory()){
                    File f = new File(outputDir, name);
                    if(!f.mkdirs()){
                        throw new IOException("Unable to create directory: "
                                + f.getAbsolutePath());
                    }
                }
                else{ // Entry is file
                    File f = new File(outputDir, name);
                    OutputStream os = null;
                    try{
                        os = new BufferedOutputStream(new FileOutputStream(f));
                        byte[] buf = new byte[1024*8];
                        int count = -1;
                        while((count=zis.read(buf))!=-1){
                            os.write(buf, 0, count);
                        }
                    }
                    finally{
                        if(os != null){
                            os.close();
                        }
                    }
                }
                zis.closeEntry();
            }
        }
        finally{
            if(zis != null){
                zis.close();
            }
        }
    }
}
