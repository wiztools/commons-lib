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

    /**
     * Returns java.util.Date object for the ISO 8601 formatted String yyyy-MM-dd.
     * @param dateStr
     * @return
     */
    public static Date getFromISODateString(final String dateStr){
        Pattern p = Pattern.compile("([0-9]{4})-([0-9]{2})-([0-9]{2})");
        Matcher m = p.matcher(dateStr);
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
}
