/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author subwiz
 */
public final class DateUtil {
    private static final SimpleDateFormat SDF_ISO_DATE = new SimpleDateFormat(
            "yyyy-MM-dd");
    private static final SimpleDateFormat SDF_ISO_TIME = new SimpleDateFormat(
            "HH:mm:ss");

    /**
     * Returns the date in ISO 8601 format yyyy-MM-dd.
     * @param date
     * @return
     */
    public static String getAsISODateString(final Date date){
        return SDF_ISO_DATE.format(date);
    }

    /**
     * Returns the date and time in ISO 8601 format yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String getAsISODateTimeString(final Date date){
        return SDF_ISO_DATE.format(date) + "T" + SDF_ISO_TIME.format(date);
    }

    private static final Pattern PATTERN_ISO_DATE = Pattern.compile("([0-9]{4})-([0-9]{2})-([0-9]{2})");

    /**
     * Returns java.util.Date object for the ISO 8601 formatted String yyyy-MM-dd.
     * @param dateStr
     * @return
     */
    public static Date getFromISODateString(final String dateStr){
        Matcher m = PATTERN_ISO_DATE.matcher(dateStr);
        if(m.matches()){
            int year = Integer.parseInt(m.group(1));
            int month = Integer.parseInt(m.group(2));
            int date = Integer.parseInt(m.group(3));

            Calendar c = Calendar.getInstance();
            c.clear();
            c.set(year, month-1, date); // Month starts from 0
            return c.getTime();
        }
        else{
            throw new IllegalArgumentException("Date string not in correct format!");
        }
    }

    private static Date getDatePlus(final int unit, final Date date, final int quantity) {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.setTime(date);
        c.add(unit, quantity);
        return c.getTime();
    }

    /**
     * Adds the number of days to the date and returns the new Date instance.
     * @param date Input date.
     * @param months Number of days to add.
     * @return Computed date.
     */
    public static Date getDatePlusDays(final Date date, final int days){
        return getDatePlus(Calendar.DATE, date, days);
    }

    /**
     * Adds the number of months to the date and returns the new Date instance.
     * @param date Input date.
     * @param months Number of months to add.
     * @return Computed date.
     */
    public static Date getDatePlusMonths(final Date date, final int months){
        return getDatePlus(Calendar.MONTH, date, months);
    }

    /**
     * Adds the number of years to the date and returns the new Date instance.
     * @param date Input date.
     * @param years Number of years to add.
     * @return Computed date.
     */
    public static Date getDatePlusYears(final Date date, final int years){
        return getDatePlus(Calendar.YEAR, date, years);
    }
}
