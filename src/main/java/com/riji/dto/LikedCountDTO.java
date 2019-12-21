package com.riji.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 杨鹏发
 * @date 2019/11/24 0024
 */
@Data
public class LikedCountDTO implements Serializable {
    private String id;

    private Integer count;

    public LikedCountDTO() {
    }

    public LikedCountDTO(String id, Integer count) {
        this.id = id;
        this.count = count;
    }
}
