package com.riji.controller.ceshiSpringBoot.ceshiJieKouDemo;

import org.springframework.stereotype.Service;

/**
 * @author 杨鹏发
 * @date 2020/4/22 0022
 */
@Service
public class FuImpl implements FuJieKou ,ZiJieKou{
    @Override
    public String getName(String name) {
        return "fafa";
    }
}
