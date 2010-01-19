package org.wiztools.commons;

import java.util.Collection;
import java.util.Set;
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
public class MultiValueMapLinkedHashSetTest {

    public MultiValueMapLinkedHashSetTest() {
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

    @Test
    public void testMultiValues(){
        // To test that same key-value duplication is allowed:
        MultiValueMap<String, String> instance = new MultiValueMapLinkedHashSet<String, String>();
        instance.put("a", "a");
        instance.put("a", "a");
        instance.put("a", "b");
        assertEquals(instance.values().size(), 2);
    }

}