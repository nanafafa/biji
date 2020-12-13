package com.riji.controller.validationedDemo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏发
 * @date 2020/12/13 0013
 */
@RestController
public class validationControllerTest {

    @GetMapping("/createOrder")
    public String validationTest(@Validated CreateOrderDTO createOrderDTO) {
        return "aaa";
    }

}
