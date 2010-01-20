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
public class CollectionsUtilTest {

    public CollectionsUtilTest() {
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
     * Test of unmodifiableMultiValueMap method, of class CollectionsUtil.
     */
    @Test
    public void testUnmodifiableMultiValueMap() {
        System.out.println("unmodifiableMultiValueMap");

        // Test for equality after making unmodifiable:
        MultiValueMap<String, String> expResult = new MultiValueMapArrayList<String, String>();
        expResult.put("a", "a");
        expResult.put("b", "b");
        MultiValueMap<String, String> result = CollectionsUtil.unmodifiableMultiValueMap(expResult);
        assertEquals(result, expResult);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualEmptyMultiValueMap(){
        MultiValueMap<String, String> m = new MultiValueMapLinkedHashSet<String, String>();
        assertEquals(m, CollectionsUtil.EMPTY_MULTI_VALUE_MAP);
        assertEquals(CollectionsUtil.EMPTY_MULTI_VALUE_MAP, m);
    }
}