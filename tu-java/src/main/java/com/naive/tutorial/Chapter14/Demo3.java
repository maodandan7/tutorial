package com.naive.tutorial.Chapter14;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/4/22
 * Description:
 */
public class Demo3 {

    public static void printInfo(Class c) {
        System.out.println("class name:" + c.getName());
        System.out.println("is Interface:" + c.isInterface());
        System.out.println("simple name:" + c.getSimpleName());
        System.out.println("Canonical name:" + c.getCanonicalName());
    }
    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.naive.tutorial.Chapter14.Model.FancyToy");
            printInfo(c);
            for(Class i : c.getInterfaces()) {
                printInfo(i);
            }
            Class up = c.getSuperclass();
            try {
                Object obj = up.newInstance();
                printInfo(obj.getClass());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
