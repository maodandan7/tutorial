package com.naive.tutorial.Chapter14;

import java.util.Arrays;
import java.util.List;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/4/21
 * Description:
 */
public class Demo1 {

    abstract class Shape {
        void draw() {
            System.out.println(this + ".draw()");
        }
        abstract public String toString();
    }

    class Circle extends Shape {
        @Override
        public String toString() {
            return "Circle";
        }
    }

    class Square extends Shape {

        @Override
        public String toString() {
            return "Square";
        }
    }

    class Triangle extends Shape {

        @Override
        public String toString() {
            return "Triangle";
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        //todo 为啥？
        List<Shape> shapes = Arrays.asList(demo1.new Circle(), demo1.new Square(), demo1.new Triangle());
        for(Shape shape : shapes) {
            shape.draw();
        }
    }
}
