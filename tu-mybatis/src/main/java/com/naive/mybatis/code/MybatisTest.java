package com.naive.mybatis.code;

import com.naive.mybatis.mapper.EmployeeMapper;
import com.naive.mybatis.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/6/18
 * Description:
 */
public class MybatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() throws Exception{

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Employee employee = sqlSession.selectOne("com.naive.mybatis.mapper.EmployeeMapper.getEmpById", 1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }

    }

    //接口式编程
    @Test
    public void test1() throws Exception{

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }

    }
}
