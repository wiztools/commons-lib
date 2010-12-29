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
public class JavaScriptTest {

    public JavaScriptTest() {
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
     * Test of escape method, of class JavaScript.
     */
    @Test
    public void testEscape() {
        System.out.println("escape");
        String str = "subhash aarthi";
        String expResult = "subhash%20aarthi";
        String result = JavaScript.escape(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of unescape method, of class JavaScript.
     */
    @Test
    public void testUnescape() {
        System.out.println("unescape");
        String str = "subhash%20aarthi";
        String expResult = "subhash aarthi";
        String result = JavaScript.unescape(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of encodeURI method, of class JavaScript.
     */
    @Test
    public void testEncodeURI() {
        System.out.println("encodeURI");
        String str = "subhash é aarthi + fun";
        String expResult = "subhash%20%C3%A9%20aarthi%20+%20fun";
        String result = JavaScript.encodeURI(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of decodeURI method, of class JavaScript.
     */
    @Test
    public void testDecodeURI() {
        System.out.println("decodeURI");
        String str = "subhash%20%C3%A9%20aarthi%20+%20fun";
        String expResult = "subhash é aarthi + fun";
        String result = JavaScript.decodeURI(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of encodeURIComponent method, of class JavaScript.
     */
    @Test
    public void testEncodeURIComponent() {
        System.out.println("encodeURIComponent");
        String str = "subhash é aarthi + fun";
        String expResult = "subhash%20%C3%A9%20aarthi%20%2B%20fun";
        String result = JavaScript.encodeURIComponent(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of decodeURIComponent method, of class JavaScript.
     */
    @Test
    public void testDecodeURIComponent() {
        System.out.println("decodeURIComponent");
        String str = "subhash%20%C3%A9%20aarthi%20%2B%20fun";
        String expResult = "subhash é aarthi + fun";
        String result = JavaScript.decodeURIComponent(str);
        assertEquals(expResult, result);
    }

}