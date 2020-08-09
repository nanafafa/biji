package com.riji.controller.mashibing.demo1;

import com.riji.java8Demo.Person;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author 杨鹏发
 * @date 2020/8/9 0009
 */
public class T01 {
    public static void main(String[] args) {
//        Person person = new Person();
//        System.out.println(ClassLayout.parseInstance(person).toPrintable());
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
