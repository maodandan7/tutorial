package com.naive.tutorial;

import com.naive.tutorial.stream.StreamTest;

import java.util.Objects;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/6/11
 * Description:
 */
public class Employee {
    private String name;
    private Integer age;
    private Double salary;
    private Status status;

    public Employee() {
    }

    public Employee(String name, Integer age, Double salary, Status status) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getSalary() {
        return salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(salary, employee.salary) &&
                status == employee.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, status);
    }
}
