package com.naive.spring5.service;

import com.naive.spring5.dao.UserDao;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/22
 * Description:
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void update() {
        System.out.println("user service update");
        userDao.update();
    }
}
