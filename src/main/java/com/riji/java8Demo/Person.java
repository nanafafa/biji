package com.riji.java8Demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

/**
 * @author 杨鹏发
 * @date 2020/5/30 0030
 */
@Data
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;

    private Users users;

    public Optional<Users> getUsers1(){
        return Optional.ofNullable(users);
    }

    public Person() {
    }
}
