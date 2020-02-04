package com.riji.dianzan;

import com.riji.dianzan.LikedStatusEnum;
import lombok.Data;

import javax.persistence.*;

/**
 * @author 杨鹏发
 * @date 2019/11/19 0019
 * 用户点赞表
 */
@Entity
@Data
@Table(name = "user_like")
public class UserLike {
    //主键id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //被点赞的用户id
    private String likedUserId;
    //点赞的用户的id
    private String likedPostId;

    //点赞的状态.默认未点赞
    private Integer status = LikedStatusEnum.UNLIKE.getCode();

    public UserLike() {
    }

    public UserLike(String likedUserId, String likedPostId, Integer status) {
        this.likedUserId = likedUserId;
        this.likedPostId = likedPostId;
        this.status = status;
    }


}
