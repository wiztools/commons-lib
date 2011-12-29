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
public class ToStringBuilderTest {
    
    public ToStringBuilderTest() {
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
    
    class Parent implements ToString {
        private String name = "Parent Name";
        
        @Override
        public ToStringBuilder getToStringBuilder() {
            ToStringBuilder toStringBuilder = new ToStringBuilder();
            toStringBuilder.append(name);
            return toStringBuilder;
        }
        
        @Override
        public final String toString() { // make it final!
            return getToStringBuilder().toString();
        }
    }
    
    class Child extends Parent {
        private String age = "From Child Age";

        @Override
        public ToStringBuilder getToStringBuilder() {
            return super.getToStringBuilder().append(age);
        }
    }

    /**
     * Test of append method, of class ToStringBuilder.
     */
    @Test
    public void testAppendParent() throws Exception {
        System.out.println("appendParent");
        Parent p = new Parent();
        String result = p.toString();
        String expResult = "{Parent Name}";
        assertEquals(expResult, result);
    }

    /**
     * Test of append method, of class ToStringBuilder.
     */
    @Test
    public void testAppendChild() throws Exception {
        System.out.println("appendChild");
        Child c = new Child();
        String result = c.toString();
        String expResult = "{Parent Name; From Child Age}";
        assertEquals(expResult, result);
    }
}
