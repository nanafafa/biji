package com.riji.util;

import lombok.Getter;

/**
 * @author 杨鹏发
 * @date 2019/11/24 0024
 */
@Getter
public enum LikedStatusEnum {
    LIKE(1,"点赞"),
    UNLIKE(0,"取消点赞/为点赞"),
    ;


    private Integer code;
    private String msg;
    LikedStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
