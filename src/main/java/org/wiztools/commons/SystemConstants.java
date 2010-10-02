/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

/**
 * This interface defines JVM properties which are accessed using
 * java.lang.System.getProperty() method. Note: These values are
 * initialized when the Class loader loads this interface. Any subsequent
 * change in System properties will not reflect in these variables.
 * @author subwiz
 */
public interface SystemConstants {
    public String fileEncoding = System.getProperty("file.encoding");
    public String fileSeparator = System.getProperty("file.separator");
    public String tmpDir = System.getProperty("java.io.tmpdir");
    public String lineSeparator = System.getProperty("line.separator");
    public String pathSeparator = System.getProperty("path.separator");
    public String userDir = System.getProperty("user.dir");
    public String userHome = System.getProperty("user.home");
    public String userLanguage = System.getProperty("user.language");
    public String userName = System.getProperty("user.name");
}
