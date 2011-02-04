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
 * @author subhash
 */
public class RotNTest {

    public RotNTest() {
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
     * Test of cipher method, of class RotN.
     */
    @Test
    public void testCipher() {
        System.out.println("cipher");
        int n = 13;
        String inString = "subhash-101-aarthi";
        String expResult = Rot13.cipher(inString);
        String result = RotN.cipher(n, inString);
        assertEquals(expResult, result);
     }

    /**
     * Test of deCipher method, of class RotN.
     */
    @Test
    public void testDeCipher() {
        System.out.println("deCipher");
        int n = 13;
        String inString = Rot13.cipher("subhash-101-aarthi");
        String expResult = "subhash-101-aarthi";
        String result = RotN.deCipher(n, inString);
        assertEquals(expResult, result);
     }
}