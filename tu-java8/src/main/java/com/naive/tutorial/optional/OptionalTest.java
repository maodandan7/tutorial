package com.naive.tutorial.optional;

import com.naive.tutorial.Employee;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Optional;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/6/11
 * Description:
 */
//Optional
public class OptionalTest {

    @Test
    public void test() {
//        Optional<Employee> optional = Optional.empty();
//        System.out.println(optional.get());
//
//        Optional<Employee> optional1 = Optional.of(null);
//        System.out.println(optional1);

//        Optional<Employee> optional2 = Optional.ofNullable(null);
//        System.out.println(optional2.get());

        Optional<Employee> optional = Optional.of(new Employee());
        Optional<String> o = optional.map(employee -> null);
//        System.out.println(o.get());

        Optional<String> s = optional.flatMap(employee -> Optional.of(employee.getName()));
        System.out.println(s.get());
    }
}
