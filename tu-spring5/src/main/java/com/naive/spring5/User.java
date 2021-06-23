package com.naive.spring5;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/21
 * Description:
 */

public class User {

    private Integer id;
    private String name;
    private String address;

    private String[] array;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> set;

    public User() {

    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public String toString() {
        return "id:" + id + "," + "name:" + name + "," + "address:" + address
                +"\n" + array + "\n" + list + "\n" + map + "\n" + set;
    }

    public void add() {
        System.out.println("add.....");
    }
}
