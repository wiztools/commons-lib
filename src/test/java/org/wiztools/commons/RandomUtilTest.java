/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 *
 * @author subwiz
 */
public class RandomUtilTest {

    public RandomUtilTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRandomStr method, of class RandomUtil.
     */
    @org.junit.Test
    public void testGetRandomStr() {
        System.out.println("getRandomStr");
        String result = RandomUtil.getRandomStr();
        assertEquals(RandomUtil.STRING_DEFAULT_LENGTH, result.length());
    }

    /**
     * Test of getRandomStr method, of class RandomUtil.
     */
    @org.junit.Test
    public void testGetRandomStr_int() {
        // Correctness of length:
        System.out.println("getRandomStr");
        int len = 8;
        String result = RandomUtil.getRandomStr(len);
        assertEquals(len, result.length());
    }

    @org.junit.Test
    public void testGetRandomStrRandomness() {
        // Correctness of length:
        System.out.println("testGetRandomStrRandomness");
        int len = 8;
        String result1 = RandomUtil.getRandomStr(len);
        String result2 = RandomUtil.getRandomStr(len);
        if(result1.equals(result2)){
            fail("Result one and two are same:" + result1 + "\t" + result2);
        }
    }

}