package com.naive.tutorial.lambda;

import com.naive.tutorial.Employee;
import com.naive.tutorial.Status;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/10/21
 * Description:
 */
public class LambdaTest {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.FREE),
            new Employee("李四", 58, 5555.4, Status.BUSY),
            new Employee("王五", 36, 3333.33, Status.VOCATION),
            new Employee("赵六", 36, 6666.66, Status.FREE),
            new Employee("田七", 12, 8888.88, Status.BUSY)
    );

    @Test
    public void test1() {
        Runnable runnable = () -> System.out.println("无参数无返回值");
        runnable.run();

        Consumer consumer = x -> System.out.println(x);
        consumer.accept("有一个参数但无返回值");

        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        System.out.println(comparator.compare(1, 2));
    }

    @Test
    public void test2() {
        Collections.sort(employees, (x, y) -> {
            if(x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            } else {
                return Integer.compare(x.getAge(), y.getAge());
            }
        });
        employees.stream().forEach(System.out::println);
    }

    @Test
    public void test3() {
        String str = "  abCdefg   ";
        str = stringHandler(str, x -> x.trim());
        str = stringHandler(str, x -> x.toUpperCase());
        str = stringHandler(str, x -> x.substring(2, 5));
        System.out.println(str);
    }


    public String stringHandler(String str, MyInterface myInterface) {
        return myInterface.getValue(str);
    }

    @Test
    public void test4() {
        Long compute = compute(100L, 200L, (x, y) -> x + y);
        System.out.println(compute);
        Long compute1 = compute(100L, 200L, (x, y) -> x * y);
        System.out.println(compute1);
    }

    public Long compute(Long l1, Long l2, Compute<Long, Long> compute) {
         return compute.compute(l1, l2);
    }

    //Java 四大函数式接口 consumer, supplier, function, predicate

    //方法引用1 对象::非静态方法
    public void test5() {
        Employee employee = new Employee();
        Supplier<String> supplier = () -> employee.getName();
        Supplier<String> supplier1 = employee::getName;
    }

    //方法引用2 类::静态方法
    public void test6() {
        Comparator<Integer> comparator = Integer::compare;
    }

    //方法引用3 类::非静态方法
    public void test7() {
        Comparator<Integer> comparator = Integer::compareTo;
    }

    //构造器引用
    public void test8() {
        Supplier<Employee> supplier = Employee::new;
    }

    //数组引用
    public void test9() {
        Function<Integer, String[]> function = String[]::new;
    }

}
