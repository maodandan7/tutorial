package com.naive.spring5.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/31
 * Description:
 */
@Component
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void add(Book book) {
        String sql = "insert into book(id,name,price) values(?,?,?)";
        jdbcTemplate.update(sql, book.getId(), book.getName(), book.getPrice());
    }

    public int getCount() {
        String sql = "select count(*) from book";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    public Book findBookById(int id) {
        String sql = "select * from book where id = ?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    public List<Book> findBookAll() {
        String sql = "select * from book";
        List<Book> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return query;
    }
}
