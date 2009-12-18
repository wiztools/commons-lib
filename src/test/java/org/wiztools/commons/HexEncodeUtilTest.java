package org.wiztools.commons;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author subhash
 */
public class HexEncodeUtilTest {

    public HexEncodeUtilTest() {
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
     * Test of byteArrayToHexString method, of class HexEncodeUtil.
     */
    @Test
    public void testByteArrayToHexString() {
        System.out.println("byteArrayToHexString");
        byte[] input = "()*!~`'\"fghfgh123098^&#@".getBytes(Charsets.UTF_8);
        String expResult = "28292a217e6027226667686667683132333039385e262340";
        String result = HexEncodeUtil.bytesToHex(input);
        assertEquals(expResult, result);
    }

}