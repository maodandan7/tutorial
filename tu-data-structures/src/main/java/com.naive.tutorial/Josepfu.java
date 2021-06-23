package com.naive.tutorial;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/10/23
 * Description:
 */
public class Josepfu {

    static class Node {
        private Integer no;
        private Node next;
    }

    static class CircleLinkedList {

    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int i=0;i<100000;i++) {
            System.out.println("haha");
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
