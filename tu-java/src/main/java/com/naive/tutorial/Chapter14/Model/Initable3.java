package com.naive.tutorial.Chapter14.Model;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/4/29
 * Description:
 */
public class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initialzing Initable3");
    }
}
