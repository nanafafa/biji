package com.riji.controller.ceshiSpringBoot.ziDingYiStart;

/**
 * @author 杨鹏发
 * @date 2020/5/17 0017
 */
public class HelloService {
    HelloProPerties helloProPerties;

    public HelloProPerties getHelloProPerties() {
        return helloProPerties;
    }

    public void setHelloProPerties(HelloProPerties helloProPerties) {
        this.helloProPerties = helloProPerties;
    }

    public String sayHello(String name){
        return  helloProPerties.getPrefix()+"-"+name+helloProPerties.getSuffix();
    }
}
