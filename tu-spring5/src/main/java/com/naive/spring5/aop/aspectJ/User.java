package com.naive.spring5.aop.aspectJ;

import org.springframework.stereotype.Service;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/28
 * Description:
 */
@Service("user1")
public class User {
    public Integer add() {
        System.out.println("add..........");
        return 0;
    }
}
