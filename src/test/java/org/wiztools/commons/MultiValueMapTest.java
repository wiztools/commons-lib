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
 * @author subwiz
 */
public class MultiValueMapTest {

    public MultiValueMapTest() {
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
     * Test of put method, of class DuplicateKeyMap.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        String key = "lovers";
        MultiValueMap<String, String> instance = new MultiValueMap<String, String>();
        List expResult = Arrays.asList(new String[]{"Aarthi", "Subhash"});
        instance.put(key, "Aarthi");
        instance.put(key, "Subhash");
        assertEquals(expResult, instance.get(key));
    }

}
