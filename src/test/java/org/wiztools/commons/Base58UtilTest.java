/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */

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
public class Base58UtilTest {

    public Base58UtilTest() {
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
     * Test of decode method, of class Base58Util.
     */
    @Test
    public void testDecode() {
        System.out.println("decode");
        for(long i = 0; i < 10000; i++) {
            final String val1 = Base58Util.encode(i);
            final long val2 = Base58Util.decode(val1);
            // System.out.println(i + "\t" + val1 + "\t" + val2);
            assertEquals(i, val2);
        }
    }

}