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
    public void testIsStrEmpty() {
        System.out.println("isStrEmpty");
        String str = "";
        boolean expResult = true;
        boolean result = StringUtil.isStrEmpty(str);
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

}