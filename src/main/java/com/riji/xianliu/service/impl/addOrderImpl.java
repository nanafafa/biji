package com.riji.xianliu.service.impl;

import com.riji.xianliu.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author 杨鹏发
 * @date 2020/8/3 0003
 */
@Service
public class addOrderImpl implements OrderService {
    @Override
    public int addOrder() {
        System.out.println("插入订单数据...");
        return 1;
    }
}
