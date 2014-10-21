/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.util.Arrays;
import java.util.List;
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
public class StringUtilTest {

    public StringUtilTest() {
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
     * Test of isStrEmpty method, of class StringUtil.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        String str = "";
        boolean expResult = true;
        boolean result = StringUtil.isEmpty(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNullStrIfNull method, of class StringUtil.
     */
    @Test
    public void testGetNullStrIfNull() {
        System.out.println("getNullStrIfNull");
        String str = null;
        String expResult = "";
        String result = StringUtil.getNullStrIfNull(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of implode method, of class StringUtil.
     */
    @Test
    public void testImplode_String_StringArr() {
        System.out.println("implode");
        String glue = ",";
        String[] pieces = new String[]{"Subhash", "Aarthi"};
        String expResult = "Subhash,Aarthi";
        String result = StringUtil.implode(glue, pieces);
        assertEquals(expResult, result);
    }

    /**
     * Test of implode method, of class StringUtil.
     */
    @Test
    public void testImplode_StringArr() {
        System.out.println("implode");
        String[] pieces = new String[]{"Aarthi", " ", "Subhash"};
        String expResult = "Aarthi Subhash";
        String result = StringUtil.implode(pieces);
        assertEquals(expResult, result);
    }

    @Test
    public void testExplode() {
        System.out.println("explode");
        String str = "subhash.chandran.";
        String delimiter = ".";
        List expResult = Arrays.asList(new String[]{"subhash", "chandran", ""});
        List result = StringUtil.explode(delimiter, str);
        assertEquals(expResult, result);
    }

    @Test
    public void testExplode_Multi() {
        System.out.println("explode");
        String str = "subhash.x.chandran.x.";
        String delimiter = ".x.";
        List expResult = Arrays.asList(new String[]{"subhash", "chandran", ""});
        List result = StringUtil.explode(delimiter, str);
        assertEquals(expResult, result);
    }

    @Test
    public void testExplodeFirst() {
        System.out.println("explodeFirst");

        String str = "subhash.x.aarthi.x.s";
        String delimiter = ".x.";
        List expResult = Arrays.asList(new String[]{"subhash", "aarthi.x.s"});
        List result = StringUtil.explodeFirst(delimiter, str);
        assertEquals(expResult, result);
    }

    @Test
    public void testExplodeLast() {
        System.out.println("testExplodeLast");

        String str = "subhash.x.aarthi.x.s";
        String delimiter = ".x.";
        List expResult = Arrays.asList(new String[]{"subhash.x.aarthi", "s"});
        List result = StringUtil.explodeLast(delimiter, str);
        assertEquals(expResult, result);
    }

    // @Test Commenting because fails in some conditions...
    public void testExplodeSpeed() {
        System.out.println("speed test of split");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < 10000; i++) {
            sb.append("subhash.chandran.s.");
        }

        final String str = sb.toString();

        long start = System.currentTimeMillis();
        str.split("\\.");
        long end = System.currentTimeMillis();
        final long regexSplitTime = end - start;

        System.out.println("String default split: " + regexSplitTime);

        start = System.currentTimeMillis();
        StringUtil.explode(".", str);
        end = System.currentTimeMillis();
        final long mySplitTime = end - start;

        System.out.println("String my split: " + mySplitTime);

        // If we do not have the split time advantage, it is no use having our split functionality!
        assertTrue(mySplitTime < regexSplitTime);
    }

    @Test
    public void testCapatilizeFirstLetter() {
        System.out.println("capatilizeFirstLetter");
        String input = "subhash chandran";
        String expResult = "Subhash chandran";
        assertEquals(expResult, StringUtil.capatilizeFirstLetter(input));

        // First letter is already capatilized:
        input = "Aarthi Rajan";
        expResult = "Aarthi Rajan";
        assertEquals(expResult, StringUtil.capatilizeFirstLetter(input));
    }

    @Test
    public void testCapatilizeFirstLetterEachWord() {
        System.out.println("capatilizeFirstLetterEachWord");
        String input = "miles o'Brien";
        String expResult = "Miles O'Brien";
        assertEquals(expResult, StringUtil.capatilizeFirstLetterEachWord(input));
    }

    @Test
    public void testReverseCapitalization() {
        System.out.println("reverseCapitalization");
        String input = "WizTools.org";
        String expResult = "wIZtOOLS.ORG";
        assertEquals(expResult, StringUtil.reverseCapitalization(input));
    }
    
    @Test
    public void testLanguageTrim() {
        System.out.println("languageTrim");
        
        {
            final String input = "Lorem ipsum dolor sit amet, consectetur adipisicing elit";
            final int length = 20;
            String expResult = "Lorem ipsum dolor";
            assertEquals(expResult, StringUtil.languageTrim(input, length));
        }
        {
            final String input = "Lorem ipsum dolor sit amet, consectetur adipisicing elit";
            final int length = 4;
            String expResult = "Lore";
            assertEquals(expResult, StringUtil.languageTrim(input, length));
        }
        {
            final String input = "Lorem ipsum dolor sit amet, consectetur adipisicing elit";
            final int length = 60;
            String expResult = input;
            assertEquals(expResult, StringUtil.languageTrim(input, length));
        }
    }
}