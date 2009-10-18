package org.wiztools.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
public class StreamUtilTest {

    public StreamUtilTest() {
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
    private final Charset TEST_CHARSET = CommonCharset.ISO_8859_1;

    /**
     * Test of inputStream2String method, of class StreamUtil.
     */
    @Test
    public void testInputStream2String() throws Exception {
        System.out.println("inputStream2String");
        File f = File.createTempFile("wiztools", "wiz");
        FileUtil.writeString(f, TEST_STR, TEST_CHARSET);
        InputStream in = new FileInputStream(f);
        Charset charset = TEST_CHARSET;
        String expResult = TEST_STR;
        String result = StreamUtil.inputStream2String(in, charset);
        assertEquals(expResult, result);
    }

}