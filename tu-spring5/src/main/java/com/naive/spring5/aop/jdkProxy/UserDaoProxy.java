package com.naive.spring5.aop.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/28
 * Description:
 */
public class UserDaoProxy implements InvocationHandler {

    private Object obj;

    public UserDaoProxy(UserDao userDao) {
        obj = userDao;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "方法执行之前");
        Object invoke = method.invoke(obj, args);
        System.out.println(method.getName() + "方法执行之后");
        return invoke;
    }
}
