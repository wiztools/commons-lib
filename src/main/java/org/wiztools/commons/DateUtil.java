/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        try{
            Format fmt = new SimpleDateFormat("yyyy-MM-dd");
            return (Date) fmt.parseObject(dateStr);
        }
        catch(ParseException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    /**
     * This is an inclusive method: returns true if the date is equal to startDate or endDate.
     * @param startDate The start date.
     * @param endDate The end date.
     * @param date The date to verify.
     * @return true if the date falls between start date and end date.
     */
    public static boolean isDateBetween(final Date startDate,
            final Date endDate,
            final Date date) {
        // check if end date is later than start date:
        if(startDate.compareTo(endDate) > 0) {
            throw new IllegalArgumentException("Start date cannot be greater than end date!");
        }
        if(date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0) {
            return true;
        }
        return false;
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

    // Date Parsing using common pattern:
    private static final Pattern p1 = Pattern.compile("[0-9]{1,2}-[0-9]{1,2}-[0-9]{2}");
    private static final SimpleDateFormat sdf_p1 = new SimpleDateFormat("dd-MM-yy");

    private static final Pattern p2 = Pattern.compile("[0-9]{1,2}-[0-9]{1,2}-[0-9]{4}");
    private static final SimpleDateFormat sdf_p2 = new SimpleDateFormat("dd-MM-yyyy");

    private static final Pattern p3 = Pattern.compile("[0-9]{1,2}/[0-9]{1,2}/[0-9]{2}");
    private static final SimpleDateFormat sdf_p3 = new SimpleDateFormat("dd/MM/yy");

    private static final Pattern p4 = Pattern.compile("[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}");
    private static final SimpleDateFormat sdf_p4 = new SimpleDateFormat("dd/MM/yyyy");

    private static final Pattern p5 = Pattern.compile("[A-Za-z]{3} [0-9]{1,2}, [0-9]{4}");
    private static final SimpleDateFormat sdf_p5 = new SimpleDateFormat("MMM dd, yyyy");

    private static final Pattern p6 = Pattern.compile("[A-Za-z]{3} [0-9]{1,2} [0-9]{4}");
    private static final SimpleDateFormat sdf_p6 = new SimpleDateFormat("MMM dd yyyy");

    private static final Pattern p7 = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
    private static final SimpleDateFormat sdf_p7 = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Tries to match common patterns by which date is mentioned, and returns a Date object.
     * @param dateStr The date in common pattern.
     * @return The java.util.Date object constructed by parsing the input string.
     * @throws ParseException Thrown when not able to parse the date string.
     */
    public static Date getDateFromString(final String dateStr) throws ParseException{
        SimpleDateFormat sdf = null;
        if(p1.matcher(dateStr).matches()){
            sdf = sdf_p1;
        }
        else if(p2.matcher(dateStr).matches()){
            sdf = sdf_p2;
        }
        else if(p3.matcher(dateStr).matches()){
            sdf = sdf_p3;
        }
        else if(p4.matcher(dateStr).matches()){
            sdf = sdf_p4;
        }
        else if(p5.matcher(dateStr).matches()){
            sdf = sdf_p5;
        }
        else if(p6.matcher(dateStr).matches()){
            sdf = sdf_p6;
        }
        else if(p7.matcher(dateStr).matches()){
            sdf = sdf_p7;
        }

        if(sdf != null){
            return sdf.parse(dateStr);
        }

        throw new ParseException(dateStr + " does not match any defined pattern!", 0);
    }

    public static Date now(){
        return new Date();
    }
}
