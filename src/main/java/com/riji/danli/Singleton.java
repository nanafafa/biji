package com.riji.danli;

/**
 * @author 杨鹏发
 * @date 2020/7/19 0019
 */
public class Singleton {

    private String name;
    private Integer age;



    public static void setSingleton(Singleton singleton) {
        Singleton.singleton = singleton;
    }

    private static Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance(){
        if(null==singleton){
            singleton=new Singleton();
        }
        return singleton;
    }

    public static void show(){
        System.out.println(singleton);
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

    public static Singleton getSingleton() {
        return singleton;
    }
}
