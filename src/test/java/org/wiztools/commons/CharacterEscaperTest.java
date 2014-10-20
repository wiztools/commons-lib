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
public class CharacterEscaperTest {
    
    public CharacterEscaperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of escape method, of class CharacterEscaper.
     */
    @Test
    public void testEscape() {
        System.out.println("escape");
        CharacterEscaper instance = new CharacterEscaper("+-&|!(){}[]^\"~*?:\\");
        String expResult = "\\\"Subhash \\{Aarthi\\}\\\"";
        String result = instance.escape("\"Subhash {Aarthi}\"");
        assertEquals(expResult, result);
    }
    
}
