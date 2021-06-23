package com.naive.tutorial.Chapter14.Model;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/4/29
 * Description:
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception{
        Class<FancyToy> ftClass = FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
//        Class<Toy> up2 = ftClass.getSuperclass();
        Object object = up.newInstance();
        Toy t = new FancyToy();
        Class<FancyToy> fancyToyType = FancyToy.class;
        FancyToy fancyToy1 = fancyToyType.cast(t);
        fancyToy1 = (FancyToy) t;
    }
}
