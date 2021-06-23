package com.naive.tutorial.lambda;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/6/15
 * Description:
 */
@FunctionalInterface
public interface Compute<T, R> {
    public R compute(T t1, T t2);
}
