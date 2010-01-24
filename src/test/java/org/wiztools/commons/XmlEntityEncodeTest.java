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
public class XmlEntityEncodeTest {

    public XmlEntityEncodeTest() {
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
     * Test of encode method, of class XmlEntityEncode.
     */
    @Test
    public void testEncode() {
        System.out.println("encode");
        String input = "subhash<chandran>&\"Aarthi Rajan\"'s love";
        String expResult = "subhash&lt;chandran&gt;&amp;&quot;Aarthi Rajan&quot;&apos;s love";
        String result = XmlEntityEncode.encode(input);
        assertEquals(expResult, result);
    }

}