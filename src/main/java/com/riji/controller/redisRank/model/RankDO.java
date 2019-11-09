package com.riji.controller.redisRank.model;

import java.io.Serializable;

/**
 * @author 杨鹏发
 * @date 2019/10/23 0023
 */

public class RankDO implements Serializable {
    // 用来表明具体的用户
    private long userId;
    // 用户在排行榜上的排名
    private long rank;
    // 用户的历史最高积分，也就是排行榜上的积分
    private float score;

    public RankDO() {
    }

    public RankDO(long userId, long rank, float score) {
        this.userId = userId;
        this.rank = rank;
        this.score = score;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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
