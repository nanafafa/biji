package com.riji.controller.ceshiJson;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 杨鹏发
 * @date 2020/6/11 0011
 */
@RestController
public class CeshiListController {

    @RequestMapping("/getList")
    public List<String> getAll(){
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        return list;
    }
    @PostMapping("/MapJson")
    public CeshiJso getShow(@RequestBody Map<String,Object> map){
        String name =(String) map.get("name");
        int age=(Integer) map.get("age");
        CeshiJso ceshiJso = new CeshiJso();
        ceshiJso.setName(name);
        ceshiJso.setAge(age);
        return ceshiJso;

    }

    /**
     * {
     *
     * "list":
     * [
     *     {
     *         "name": "qwer",
     *         "age": "13"
     *     },
     *     {
     *         "name": "rewq",
     *         "age": "16"
     *     }
     * ]
     *
     * }
     *
     * @param map
     * @return
     */
    @PostMapping("/MapJson1")
    public List<CeshiJso> getShow1(@RequestBody Map<String,List> map){
        List list =(List) map.get("list");
        list.stream().forEach((s)->{
            System.out.println(s);
        });
        return list;

    }


    @PostMapping("/ListJson")//http://localhost:8080/ListJson?list=nana&list=23
    public List<Object> getListShow(@RequestParam List<Object> list){//RequestParam就是在url的  虽然post在body中

        return list;

    }

    /**
     * [
     *     {
     *         "name": "qwer",
     *         "age": "13"
     *     },
     *     {
     *         "name": "rewq",
     *         "age": "16"
     *     }
     * ]
     * @param list
     * @return
     */
    @PostMapping("/ListJson1")//用CeshiJso当泛型也可以接收
    public List<CeshiJso> getListShow1(@RequestBody List<CeshiJso> list){
        list.stream().forEach((s) ->{
            System.out.println(s.getAge());
            System.out.println(s.getName());
        });
        return list;

    }


    public static void main(String[] args) {//[name, age, name]
        ArrayList<String> list = new ArrayList<>();
        list.add("name");
        list.add("age");
        list.add("name");
        System.out.println(list);
    }
}
