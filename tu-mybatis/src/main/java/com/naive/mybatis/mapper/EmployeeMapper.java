package com.naive.mybatis.mapper;

import com.naive.mybatis.model.Employee;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/6/18
 * Description:
 */
public interface EmployeeMapper {
    Employee getEmpById(Integer id);
}
