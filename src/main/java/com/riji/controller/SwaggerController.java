package com.riji.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏发
 * @date 2019/11/9 0009
 */
@Api("Swagger控制器")
@RestController
public class SwaggerController {
    @ApiOperation("艺人档期列表")
    @RequestMapping("/show")
    public String swaggerIndex(@RequestParam("page") String page,
                               @RequestParam("pageSize") String pageSize,
                               @RequestParam("condition") String condition){
        return "fagedingdan";
    }
    @ApiOperation("获取会员的相关信息")
    @ApiImplicitParam(name="userName",value = "用户信息参数",required = true,dataType = "String")
    @RequestMapping("/getMember")
    public String getMember(String userName){
        return "username";
    }
}
