package com.naive.tutorial.date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/6/15
 * Description:
 */
//日期api
public class DateTest {
    //LocalDateTime, LocalDate, LocalTime
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime localDateTime = LocalDateTime.of(2021, 6, 15, 11, 49, 50);
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = ldt.plusDays(4);
        System.out.println(localDateTime1);

        System.out.println(ldt.getDayOfWeek());
        System.out.println(ldt.getDayOfMonth());
    }
    //Instant
    @Test
    public void test2() {
        Instant now = Instant.now();
        System.out.println(now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);


        long l = now.toEpochMilli();
        System.out.println(l);

        Instant instant = Instant.ofEpochSecond(1);
        System.out.println(instant);
    }
    //Duration
    @Test
    public void test3() throws InterruptedException {
        Instant instant1 = Instant.now();
        Thread.sleep(1000);
        Instant instant2 = Instant.now();
        Duration between = Duration.between(instant1, instant2);
        System.out.println(between.toMillis());

        LocalTime localTime1 = LocalTime.now();
        Thread.sleep(1000);
        LocalTime localTime2 = LocalTime.now();
        Duration between1 = Duration.between(localTime2, localTime1).abs();
        System.out.println(between1.toMillis());

    }

    //Period
    @Test
    public void test4() {
        LocalDate now = LocalDate.now();
        LocalDate of = LocalDate.of(2021, 8, 22);
        Period between = Period.between(now, of);
        int years = between.getYears();
        System.out.println(years);
        int months = between.getMonths();
        System.out.println(months);
        int days = between.getDays();
        System.out.println(days);

    }
    //TemporalAdjuster: 时间矫正器
    @Test
    public void test5() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime localDateTime = now.withDayOfMonth(20);
        System.out.println(localDateTime);
        LocalDateTime with = now.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(with);
    }

    //DateTimeFormatter:格式化时间/日期
    @Test
    public void test6() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toEpochSecond(ZoneOffset.ofHours(8)));
        DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
        String format = now.format(isoDate);
        System.out.println(format);
        DateTimeFormatter isoLocalDate = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.println(now.format(isoLocalDate));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format1 = now.format(dateTimeFormatter);
        System.out.println(format1);

        String dateString = "2021-06-15 15:11:08";
        LocalDateTime parse = LocalDateTime.parse(dateString, dateTimeFormatter);
        System.out.println(parse);

        Instant instant = parse.atZone(ZoneId.systemDefault()).toInstant();
        Date from = Date.from(instant);
        System.out.println(from);
    }

    //ZoneDate, ZoneTime, ZoneDateTime
    @Test
    public void test7() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now);
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime.toLocalDateTime());
        long l = now.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println(l);
        long l1 = now.toEpochSecond(ZoneOffset.ofHours(8));
        System.out.println(l1);
    }



}
