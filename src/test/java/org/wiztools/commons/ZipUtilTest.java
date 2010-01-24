/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author subwiz
 */
public class ZipUtilTest {

    public ZipUtilTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of unzip method, of class ZipUtil.
     */
    @Test
    public void testUnzip() throws Exception {
        System.out.println("unzip");
        File input = new File("src/test/resources/qdox-1.9-javadoc.jar");
        File outputDir = new File(System.getProperty("java.io.tmpdir"),
                RandomUtil.getRandomStr(4));
        outputDir.mkdir();
        ZipUtil.unzip(input, outputDir);
        outputDir.delete();
    }

}
