package com.naive.spring5.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/31
 * Description:
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    public void addBook() {
        Book book = new Book();
        book.setId(2);
        book.setName("python");
        book.setPrice(123.0);
        bookDao.add(book);
    }

    public void getBookCount() {
        System.out.println("book count:" + bookDao.getCount());
    }

    public void getBookById() {
        Book bookById = bookDao.findBookById(1);
        System.out.println(bookById);
    }

    public void getBookAll() {
        List<Book> bookAll = bookDao.findBookAll();
        System.out.println(bookAll);
    }
}
