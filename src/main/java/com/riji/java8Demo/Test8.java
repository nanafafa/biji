package com.riji.java8Demo;

import java.util.Optional;

/**
 * @author 杨鹏发
 * @date 2020/5/30 0030
 */
public class Test8 {
    public static void main(String[] args) {
        Person person = new Person();

        System.out.println(person.getUsers1());


        person.setAge(17);
        if(null==person){
            System.out.println("person空");
        }
        System.out.println("fafa");
//        Optional<Person> emptyOpt = Optional.empty();
//        System.out.println(emptyOpt.get());
        //Optional.ofNullable(person).orElse("person为空");
        boolean flag = Optional.ofNullable("fafa").isPresent();
        System.out.println(flag);

        System.out.println(Optional.ofNullable(person).isPresent());

        Optional.ofNullable(person).ifPresent(p -> System.out.println("年龄"+p.getAge()));
        System.out.println(Optional.ofNullable(person).filter(p-> p.getAge()>16));//Optional[Person(name=null, age=17)]

        Optional<Person> optional = Optional.ofNullable(person);//如果参数不为空，则创建有参对象Optional:Optional[Person(name=null, age=17)]
        System.out.println(optional.get());///Person(name=null, age=17)

        Users users=null;
        System.out.println( Optional.ofNullable(users));


    }
}
