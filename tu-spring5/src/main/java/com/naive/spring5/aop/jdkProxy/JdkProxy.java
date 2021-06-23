package com.naive.spring5.aop.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/28
 * Description:
 */
public class JdkProxy {

    public static void main(String[] args) {
        Class[] intefaces = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao o = (UserDao) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), intefaces, new UserDaoProxy(userDao));
        Integer add = o.add(1, 2);
        System.out.println(add);
    }

}
