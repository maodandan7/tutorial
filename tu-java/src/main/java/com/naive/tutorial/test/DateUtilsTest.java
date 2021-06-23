package com.naive.tutorial.test;

import org.apache.commons.lang.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/6/23
 * Description:
 */
public class DateUtilsTest {
    public static void main(String[] args) {
        int a = 3;
        Date date = DateUtils.addDays(new Date(), -a);
        System.out.println(date);
        Date week = DateUtils.addWeeks(new Date(), -1);
        System.out.println(week);
        int w = getWeek(DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH));
        System.out.println(w);
    }
    public static Integer getWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
