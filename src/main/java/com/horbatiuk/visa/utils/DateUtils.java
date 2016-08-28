package com.horbatiuk.visa.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Andrey on 25.08.2016.
 */
public class DateUtils {
    public static void convertMillisecondsToDate(Long milliSeconds){
        ExceptionUtils.checkLongIsLong(milliSeconds);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(formatter.format(calendar.getTime()));
    }
}
