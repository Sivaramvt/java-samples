package com.computepatterns.experiments;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 */
public class DatePerformanceExperiment {

    static int findYearUsingCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return  calendar.get(Calendar.YEAR);
    }

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        findYearUsingCalendar(new Date());
        long second = System.currentTimeMillis();
        findYearUsingCalendar(new Date());
        long last = System.currentTimeMillis();
        System.out.println(second - start);
        System.out.println(last - second);
    }
}
