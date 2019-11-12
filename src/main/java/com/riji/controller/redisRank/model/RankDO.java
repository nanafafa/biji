package com.riji.controller.redisRank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 杨鹏发
 * @date 2019/10/23 0023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankDO implements Serializable {
    /**
     * 排名
     */
    private Long rank;

    /**
     * 积分
     */
    private Float score;

    /**
     * 用户id
     */
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
