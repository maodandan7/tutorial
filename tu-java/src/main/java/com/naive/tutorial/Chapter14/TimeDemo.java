package com.naive.tutorial.Chapter14;

import org.apache.commons.lang.time.DateUtils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/4/30
 * Description:
 */
public class TimeDemo {
    private static long midTime;
    private static void countdown() throws Exception{
        Timer timer = new Timer();
        long endTime = DateUtils.parseDate("2020-05-01 09:00:00", new String[]{"yyyy-MM-dd HH:mm:ss"}).getTime();
        System.out.println(endTime);
        midTime = (endTime - new Date().getTime()) / 1000;
        System.out.println(midTime);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                midTime--;
                long hh = midTime / 60 / 60;
                long mm = midTime % (60 * 60) / 60;
                long ss = midTime % (60 * 60) % 60;
                System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
            }
        }, 0 , 1000);
    }

    public static void main(String[] args) throws Exception{
        countdown();
    }
}
