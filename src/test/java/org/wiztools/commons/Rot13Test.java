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
public class Rot13Test {

    public Rot13Test() {
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
     * Test of Cipher method, of class Rot13.
     */
    @Test
    public void testCipher() {
        System.out.println("convert");
        String inStr = "subhash-101-aarthi";
        String expResult = "fhounfu-101-nneguv";
        String result = Rot13.cipher(inStr);
        assertEquals(expResult, result);

        assertEquals(inStr, Rot13.cipher(result));
    }

}