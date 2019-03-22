package com.company.project.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * Collection of customised data formatter
 * @author Chao Li
 */
public class DataFormatter {
    /***
     * Transfer String with format 'yyyy-MM-dd' to java.util.Date object
     * @param dateStr String with format 'yyyy-MM-dd'
     * @return Date object transformed from dateStr, if parse error, return null
     */
    public static Date strToDate(String dateStr){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(dateStr);
            return date;
        } catch (ParseException e){
            System.out.println("Parse date error:"+dateStr);
        }
        return null;
    }
}
