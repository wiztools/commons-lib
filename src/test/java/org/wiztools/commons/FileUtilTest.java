/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.io.File;
import java.nio.charset.Charset;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author subwiz
 */
public class FileUtilTest {

    public FileUtilTest() {
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

    private final String TEST_STR = "áàâæ";
    
    /**
     * Test of getContentAsString method, of class FileUtil.
     */
    @Test
    public void testGetContentAsString() throws Exception {
        System.out.println("getContentAsString");
        File f = File.createTempFile("wiztools", "wiz");
        Charset charset = Charsets.ISO_8859_1;
        FileUtil.writeString(f, TEST_STR, charset);
        String expResult = TEST_STR;
        String result = FileUtil.getContentAsString(f, charset);
        assertEquals(expResult, result);
    }

}