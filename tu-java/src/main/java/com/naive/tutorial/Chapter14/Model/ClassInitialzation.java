package com.naive.tutorial.Chapter14.Model;

import java.util.Random;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/4/29
 * Description:
 */
public class ClassInitialzation {

    public static Random rand = new Random(47);

    static {
        System.out.println("Initialzing classInittialzation");
    }

    public static void main(String[] args) throws Exception{
        System.out.println(Initable.class);
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticNonFinal);
        System.out.println(Class.forName("com.naive.tutorial.Chapter14.Model.Initable3"));
    }
}
