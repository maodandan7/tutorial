package com.naive.spring5.jdbctemplate;

import org.springframework.stereotype.Component;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/31
 * Description:
 */
@Component
public class Book {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
