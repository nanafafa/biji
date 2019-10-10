package com.riji.controller;

import com.riji.pojo.JsonBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ceshi1")
public class CeshiJonFormatController {
    @RequestMapping("/a")
    public JsonBean show(@RequestBody JsonBean jsonBean){
        return jsonBean;
    }

}
