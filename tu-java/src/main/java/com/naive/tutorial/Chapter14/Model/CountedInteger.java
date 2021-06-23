package com.naive.tutorial.Chapter14.Model;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/4/29
 * Description:
 */
public class CountedInteger {
    private static long counter;
    private final long id = counter++;
    public String toString() {
        return Long.toString(id);
    }

    public static void main(String[] args) {
        CountedInteger countedInteger = new CountedInteger();
        System.out.println(CountedInteger.counter);
    }

}
