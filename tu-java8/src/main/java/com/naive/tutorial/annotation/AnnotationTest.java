package com.naive.tutorial.annotation;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/6/15
 * Description:
 */
//可重复注解和类型注解
public class AnnotationTest {

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(@MyAnnotation("abc") String str) {

    }
}
