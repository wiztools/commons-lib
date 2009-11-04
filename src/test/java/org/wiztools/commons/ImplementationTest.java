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
public class ImplementationTest {

    public ImplementationTest() {
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
     * Test of of method, of class Implementation.
     */
    @Test
    public void testOfSingleton() {
        System.out.println("of");
        MockInterface expResult = Implementation.of(MockInterface.class);
        MockInterface result = Implementation.of(MockInterface.class);
        assertSame(expResult, result);
    }

    @Test
    public void testOfNewInstance() {
        Mock2Interface expResult = Implementation.of(Mock2Interface.class);
        Mock2Interface result = Implementation.of(Mock2Interface.class);
        assertNotSame(expResult, result);
    }
}