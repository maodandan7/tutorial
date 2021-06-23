package com.naive.tutorial.stream;

import com.naive.tutorial.Employee;
import com.naive.tutorial.Status;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/6/7
 * Description:
 */
public class StreamTest {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.FREE),
            new Employee("李四", 58, 5555.4, Status.BUSY),
            new Employee("王五", 36, 3333.33, Status.VOCATION),
            new Employee("赵六", 36, 6666.66, Status.FREE),
            new Employee("田七", 12, 8888.88, Status.BUSY)
    );



    //创建流
    @Test
    public void test() {

        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        Employee[] employees = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);

        Stream<String> aa = Stream.of("aa", "bb", "cc");

        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2).limit(10);
        iterate.forEach(System.out::println);

        Stream<Double> generate = Stream.generate(Math::random).limit(5);
        generate.forEach(System.out::println);
    }

    //中间操作
    @Test
    public void test1() {
        //过滤 filter
        Stream<Employee> employeeStream = employees.stream()
                .filter(employee -> employee.getAge() > 35);
        employeeStream.forEach(System.out::println);
        System.out.println();
        //截断 limit skip
        employees.stream().limit(2).forEach(System.out::println);
        System.out.println();
        employees.stream().skip(2).forEach(System.out::println);
        System.out.println();
        //去重 distinct
        employees.stream().distinct().forEach(System.out::println);
        System.out.println();
        //映射 map flatmap
        List<String> list = Arrays.asList("ccc", "aaa", "bbb", "eee", "ddd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println();
        employees.stream().map(Employee::getName).forEach(System.out::println);
        System.out.println();
        list.stream().map(StreamTest::getCharacter).forEach(s -> s.forEach(System.out::println));
        System.out.println();
        list.stream().flatMap(StreamTest::getCharacter).forEach(System.out::println);
        //排序 sorted(Comparable)自然排序  sorted(Comparator)订制排序
        list.stream().sorted().forEach(System.out::println);
        employees.stream().sorted((e1, e2) -> {
            if (e1.getAge().equals(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        }).forEach(System.out::println);
    }

    //终止操作
    @Test
    public void test2() {
        //查找与匹配
        //allmatch
        boolean b = employees.stream().allMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b);
        System.out.println();
        //anyMatch
        boolean b1 = employees.stream().anyMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b1);
        System.out.println();
        //noneMatch
        boolean b2 = employees.stream().noneMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b2);
        System.out.println();
        //findFirst
        Optional<Employee> first = employees.stream().sorted((e1, e2) -> e2.getSalary().compareTo(e1.getSalary())).findFirst();
        System.out.println(first.get());
        System.out.println();
        //findAny
        Optional<Employee> any = employees.stream().filter(e -> e.getStatus().equals(Status.FREE)).findAny();
        System.out.println(any.get());
        System.out.println();
        //count
        long count = employees.stream().count();
        System.out.println(count);
        System.out.println();
        //max
        Optional<Employee> max = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(max.get());
        System.out.println();
        //min
        Optional<Integer> min = employees.stream().map(Employee::getAge).min(Integer::compare);
        System.out.println(min.get());
        System.out.println();
        //归约与收集
        //reduce
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list1.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        System.out.println();
        Optional<Double> reduce1 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce1.get());
        System.out.println();
        //collect
        List<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println();
        HashSet<Integer> collect1 = employees.stream().map(Employee::getAge).collect(Collectors.toCollection(HashSet::new));
        collect1.forEach(System.out::println);
        System.out.println();
        //count
        Long collect2 = employees.stream().collect(Collectors.counting());
        System.out.println(collect2);
        System.out.println();
        //average
        Double collect3 = employees.stream().collect(Collectors.averagingInt(Employee::getAge));
        System.out.println(collect3);
        System.out.println();
        //sum
        Double collect4 = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(collect4);
        System.out.println();
        //max
        Optional<Employee> collect5 = employees.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(collect5.get());
        System.out.println();
        //groupby
        Map<Status, Map<String, List<Employee>>> collect6 = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
            if (((Employee) e).getAge() <= 35) {
                return "青年";
            } else if (((Employee) e).getAge() <= 50) {
                return "中年";
            } else {
                return "老年";
            }
        })));
        System.out.println(collect6);
        System.out.println();
        //partitionBy
        Map<Boolean, List<Employee>> collect7 = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 5000));
        System.out.println(collect7);
        System.out.println();
        //统计
        DoubleSummaryStatistics collect8 = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect8.getMax());
        System.out.println(collect8.getAverage());
        System.out.println(collect8.getMin());
        System.out.println(collect8.getSum());
        System.out.println(collect8.getCount());
        System.out.println();
        //joining
        String collect9 = employees.stream().map(Employee::getName).collect(Collectors.joining(",", "name:[", "]"));
        System.out.println(collect9);
        System.out.println();
    }

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().map(e -> e * e).forEach(System.out::println);
        System.out.println();

        Integer reduce = employees.stream().map(employee -> 1).reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        System.out.println();

        long count = employees.stream().count();
        System.out.println(count);
    }

    public static Stream<Character> getCharacter(String str) {
        List<Character> characters = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            characters.add(character);
        }
        return characters.stream();
    }

}
