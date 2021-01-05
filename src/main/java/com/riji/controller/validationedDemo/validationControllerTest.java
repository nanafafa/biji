package com.riji.controller.validationedDemo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

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


    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("109.45");
        BigDecimal bigDecimal2 = new BigDecimal("0.94");
        BigDecimal result = bigDecimal1.multiply(bigDecimal2);
        result=result.setScale(0,BigDecimal.ROUND_HALF_UP);
        System.out.println(result);

    }

}
