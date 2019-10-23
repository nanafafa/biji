package com.riji.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.riji.dao.UserMapperPlus;
import com.riji.pojo.User;
import com.riji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 杨鹏发
 * @date 2019/10/13 0013
 */
@RestController
public class MybatisPlusController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapperPlus userMapperPlus;
    @RequestMapping("/ceshiPlus")
    public User insert(@RequestParam("userMail") String userMail,
                       @RequestParam("userPassword") String userPassword){

        User user = userService.insert(userMail, userPassword);
        return user;
    }
    /**
     * 按条件分页查询
     */
    @GetMapping("getUserListByPage")
    public List<User> getUserListByPage(Integer pageNumber,Integer pageSize){
        Page<User> page = new Page<>(pageNumber, pageSize);
        EntityWrapper<User> ew = new EntityWrapper<>();
        ew.eq("user_mail","yyy");
        List<User> users = userMapperPlus.selectPage(page, ew);
        return users;
    }
}
