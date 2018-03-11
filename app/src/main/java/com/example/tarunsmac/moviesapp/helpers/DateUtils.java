package com.example.tarunsmac.moviesapp.helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by tarunsmac on 11/03/18.
 */
public final class  DateUtils {

    public static int getYear(String fromDate, String format) throws ParseException{

        DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        Date date = dateFormat.parse(fromDate);

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);

        return year;
    }

}
