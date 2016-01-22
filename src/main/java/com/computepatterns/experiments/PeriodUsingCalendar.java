package com.computepatterns.experiments;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 */
public class PeriodUsingCalendar {

    public static void main(String[] args) {
        DateTime startDate = new DateTime().withDate(2015, 05, 31);
        DateTime endDate = new DateTime().withDate(2015, 11, 30);

        Period period = new Period(startDate, endDate).normalizedStandard();

        System.out.println(PeriodFormat.getDefault().print(period));



    }
}

