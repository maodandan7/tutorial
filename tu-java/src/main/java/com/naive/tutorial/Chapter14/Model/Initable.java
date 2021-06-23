package com.naive.tutorial.Chapter14.Model;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/4/29
 * Description:
 */
public class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialzation.rand.nextInt(1000);
    static {
        System.out.println("Initialzing Initable");
    }
}
