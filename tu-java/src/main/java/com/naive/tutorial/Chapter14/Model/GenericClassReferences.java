package com.naive.tutorial.Chapter14.Model;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/4/29
 * Description:
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class; //泛型语法，可以让编译器执行类型检查
        intClass = double.class;
        //genericIntClass = double.class;
        Class<? extends Number> genericNumberClass = int.class;
        genericNumberClass = double.class;
        genericNumberClass = Number.class;

    }
}
