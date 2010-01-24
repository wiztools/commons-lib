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
public class ArrayUtilTest {

    public ArrayUtilTest() {
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
     * Test of concat method, of class ArrayUtil.
     */
    @Test
    public void testConcat_GenericType() {
        System.out.println("concat");
        String[] expResult = new String[]{"Subhash", "Aarthi"};
        String[] result = ArrayUtil.concat(new String[]{"Subhash"}, new String[]{"Aarthi"});
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of concat method, of class ArrayUtil.
     */
    @Test
    public void testConcat_shortArrArr() {
        System.out.println("concat");
        short[] expResult = new short[]{1, 2};
        short[] result = ArrayUtil.concat(new short[]{1}, new short[]{2});
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of concat method, of class ArrayUtil.
     */
    @Test
    public void testConcat_longArrArr() {
        System.out.println("concat");
        long[] expResult = new long[]{1l, 2l, 3l};
        long[] result = ArrayUtil.concat(new long[]{1l, 2l}, new long[]{3l});
        assertArrayEquals(expResult, result);
    }

}