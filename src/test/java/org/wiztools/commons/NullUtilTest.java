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
public class NullUtilTest {

    public NullUtilTest() {
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
     * Test of isAnyNull method, of class NullUtil.
     */
    @Test
    public void testIsAnyNull() {
        System.out.println("isAnyNull");
        boolean expResult = false;
        boolean result = NullUtil.isAnyNull("subhash", "aarthi");
        assertEquals(expResult, result);
    }

    @Test
    public void testIsAnyNullNegative() {
        System.out.println("isAnyNull");
        boolean expResult = true;
        boolean result = NullUtil.isAnyNull("subhash", "aarthi", null);
        assertEquals(expResult, result);
    }

    /**
     * Test of isAllNull method, of class NullUtil.
     */
    @Test
    public void testIsAllNull() {
        System.out.println("isAllNull");
        boolean expResult = false;
        boolean result = NullUtil.isAllNull("subhash", "aarthi");
        assertEquals(expResult, result);
    }

    @Test
    public void testIsAllNullNegative() {
        System.out.println("isAllNull");
        boolean expResult = true;
        boolean result = NullUtil.isAllNull(null, null);
        assertEquals(expResult, result);
    }
}