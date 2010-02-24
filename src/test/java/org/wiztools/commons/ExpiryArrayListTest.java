/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ExpiryArrayListTest {

    public ExpiryArrayListTest() {
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
     * Test of getData method, of class ExpiryArrayList.
     */
    @Test
    public void testTiming() {
        System.out.println("testTiming");
        ExpiryCollection<String> instance = new ExpiryArrayList<String>(50);
        final String data = "Aarthi";

        instance.acquire();
        instance.add(data, System.currentTimeMillis() + 30);
        assertEquals(instance.contains(data), true);
        instance.release();

        // Sleep for 60 mills, so that the sleeper thread runs:
        try {
            Thread.sleep(60);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(ExpiryArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        instance.acquire();
        assertEquals(instance.contains(data), false);
        instance.release();
    }

}