package com.naive.tutorial.Chapter14.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/4/29
 * Description:
 */
public class FilledList<T> {
    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> result = new ArrayList<T>();
        try {
            for (int i = 0; i < nElements; i++) {
                result.add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> f1 = new FilledList<CountedInteger>(CountedInteger.class);
        System.out.println(f1.create(15));
    }
}
