package com.riji.controller.validationedDemo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author 杨鹏发
 * @date 2020/12/13 0013
 */
@Data
public class CreateOrderDTO {
    @NotNull(message = "订单号不能为空")
    private String orderId;
    @NotNull(message = "订单金额不能为空")
    @Min(value = 1, message = "订单金额不能小于0")
    private Integer amount;
    @Pattern(regexp = "^1[3|4|5|7|8][0-9]{9}$", message = "用户手机号不合法")
    private String mobileNo;
    private String orderType;
    private String status;
}
