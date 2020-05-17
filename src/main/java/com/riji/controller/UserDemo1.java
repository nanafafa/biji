package com.riji.controller;

/**
 * @author 杨鹏发
 * @date 2020/5/10 0010
 */
public class UserDemo1 {
    private String name;
    private Integer age;

    public UserDemo1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
