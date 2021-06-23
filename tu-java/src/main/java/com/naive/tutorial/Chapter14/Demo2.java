package com.naive.tutorial.Chapter14;

import com.naive.tutorial.Chapter14.Model.Candy;
import com.naive.tutorial.Chapter14.Model.Cookie;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/4/21
 * Description:
 */
public class Demo2 {
   //todo 内部类不能声明静态的东西？
   public static void main(String[] args) {
       new Candy();
       try {
           Class.forName("com.naive.tutorial.Chapter14.Model.Gum");
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
       new Cookie();
   }
}
