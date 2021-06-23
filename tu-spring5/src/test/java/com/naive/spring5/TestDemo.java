package com.naive.spring5;

import com.naive.spring5.jdbctemplate.BookService;
import com.naive.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/21
 * Description:
 */
public class TestDemo {

    @Test
    public void testUser() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();

        UserService userService = context.getBean("userService", UserService.class);
        userService.update();

        com.naive.spring5.aop.aspectJ.User user1 = context.getBean("user1", com.naive.spring5.aop.aspectJ.User.class);
        user1.add();

        BookService bookService = context.getBean("bookServiceImpl", BookService.class);
//        bookService.addBook();
        bookService.getBookCount();
        bookService.getBookById();
        bookService.getBookAll();

    }
}
