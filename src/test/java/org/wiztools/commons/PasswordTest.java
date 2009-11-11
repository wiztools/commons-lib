package org.wiztools.commons;

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
public class PasswordTest {

    public PasswordTest() {
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
     * Test of md5 method, of class Password.
     */
    @Test
    public void testMd5() {
        System.out.println("md5");
        String password = "subhash";
        String expResult = "0fd6ca6dd27d00b7bed0cf3e6cba6ce2";
        String result = Password.md5(password);
        assertEquals(expResult, result);
    }

}