package com.naive.spring5.jdbctemplate;

import org.springframework.stereotype.Component;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/31
 * Description:
 */
public interface BookService {
    void addBook();

    void getBookCount();

    void getBookById();

    void getBookAll();
}
