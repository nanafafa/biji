package com.riji.controller;

import com.riji.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏发
 * @date 2019/11/1 0001
 */
@RestController
public class MailController {
    @Autowired
    private MailService mailService;
    @RequestMapping("/send")
    public String sendMailDemo(){
        String message=mailService.sendSimpleEmail("473066712@qq.com","测试邮件","测试邮件内容");
        return message;

    }

}
