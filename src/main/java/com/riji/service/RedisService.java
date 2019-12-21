package com.riji.service;

import com.riji.dto.LikedCountDTO;
import com.riji.pojo.UserLike;

import java.util.List;

/**
 * @author 杨鹏发
 * @date 2019/11/19 0019
 * 设点赞人的 id 为 likedPostId，被点赞人的 id 为 likedUserId
 * 所以如果用户点赞，存储的键为：likedUserId::likedPostId，对应的值为 1 。
 *
 * 取消点赞，存储的键为：likedUserId::likedPostId，对应的值为 0 。
 *
 * 取数据时把键用 :: 切开就得到了两个id，也很方便。
 */
public interface RedisService {
    /**
     * 点赞 状态为1
     * @param likedUserId
     * @param likedPostId
     */
    void saveLiked2Redis(String likedUserId, String likedPostId);
    /**
     * 取消点赞。将状态改变为0
     * @param likedUserId
     * @param likedPostId
     */
    void unlikeFromRedis(String likedUserId, String likedPostId);

    /**
     * 从Redis中删除一条点赞数据
     * @param likedUserId
     * @param likedPostId
     */
    void deleteLikedFromRedis(String likedUserId, String likedPostId);
    /**
     * 该用户的点赞数加1（被点赞的）
     * @param likedUserId
     */
    void incrementLikedCount(String likedUserId);
    /**
     * 该用户的点赞数减1
     * @param likedUserId
     */
    void decrementLikedCount(String likedUserId);
    /**
     * 获取Redis中存储的所有点赞数据
     * @return
     */
    List<UserLike> getLikedDataFromRedis();
    /**
     * 获取Redis中存储的所有点赞数量
     * @return
     */
    List<LikedCountDTO> getLikedCountFromRedis();

}
