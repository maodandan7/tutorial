package com.naive.spring5.jdbctemplate;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/31
 * Description:
 */
public interface BookDao {
    void add(Book book);

    int getCount();

    Book findBookById(int id);

    List<Book> findBookAll();
}
