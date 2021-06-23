package com.naive.spring5.aop.jdkProxy;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/28
 * Description:
 */
public class UserDaoImpl implements UserDao{
    public Integer add(int a, int b) {
        return a + b;
    }
}
