package com.naive.tutorial.Chapter14.Model;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/4/22
 * Description:
 */
public class FancyToy extends Toy implements HasBatteries, Shoots, WaterProof {
    FancyToy() {
        super(1);
    }
}
