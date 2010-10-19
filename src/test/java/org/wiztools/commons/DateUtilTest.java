/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class DateUtilTest {

    public DateUtilTest() {
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
    public void testIsDateBetween() {
        System.out.println("isDateBetween()");
        Date now = DateUtil.now();
        Date startDate = DateUtil.getDatePlusDays(now, -1);
        Date endDate = DateUtil.getDatePlusDays(now, 1);
        assertTrue(DateUtil.isDateBetween(startDate, endDate, now));
    }

    /**
     * Test of getAsISODateString method, of class DateUtil.
     */
    @Test
    public void testGetAsISODateString() {
        System.out.println("getAsISODateString");
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(Calendar.YEAR, 1979);
        c.set(Calendar.MONTH, 1); // 1 means Feb.
        c.set(Calendar.DATE, 15);
        Date date = c.getTime();
        String expResult = "1979-02-15";
        String result = DateUtil.getAsISODateString(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAsISODateTimeString method, of class DateUtil.
     */
    @Test
    public void testGetAsISODateTimeString() {
        System.out.println("getAsISODateTimeString");
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(Calendar.YEAR, 1979);
        c.set(Calendar.MONTH, 1); // 1 means Feb.
        c.set(Calendar.DATE, 15);
        c.set(Calendar.HOUR, 5);
        c.set(Calendar.MINUTE, 5);
        c.set(Calendar.SECOND, 5);
        Date date = c.getTime();
        String expResult = "1979-02-15T05:05:05";
        String result = DateUtil.getAsISODateTimeString(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFromISODateString method, of class DateUtil.
     */
    @Test
    public void testGetFromISODateString() {
        System.out.println("getFromISODateString");
        String dateStr = "1979-02-15";
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(Calendar.YEAR, 1979);
        c.set(Calendar.MONTH, 1); // 1 means Feb.
        c.set(Calendar.DATE, 15);
        Date expResult = c.getTime();
        Date result = DateUtil.getFromISODateString(dateStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDatePlusDays() {
        System.out.println("getDatePlusDays");
        
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(Calendar.YEAR, 1979);
        c.set(Calendar.MONTH, 1); // 1 means Feb.
        c.set(Calendar.DATE, 15);

        Date date = DateUtil.getDatePlusDays(c.getTime(), 5);

        assertEquals(new SimpleDateFormat("dd-MM-yyyy").format(date), "20-02-1979");
    }

    @Test
    public void testGetDateFromString() throws Exception {
        Date d = DateUtil.getDateFromString("jan 1, 2010");
        assertEquals(new SimpleDateFormat("dd-MM-yyyy").format(d), "01-01-2010");

        d = DateUtil.getDateFromString("1-1-2010");
        assertEquals(new SimpleDateFormat("dd-MM-yyyy").format(d), "01-01-2010");

        d = DateUtil.getDateFromString("1/1/10");
        assertEquals(new SimpleDateFormat("dd-MM-yyyy").format(d), "01-01-2010");
    }
}