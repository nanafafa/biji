package com.riji.dianzan;

import java.util.List;

/**
 * @author 杨鹏发
 * @date 2020/2/1 0001
 *
 * 设点赞人的 id 为 likedPostId，被点赞人的 id 为 likedUserId
 */
public interface RedisService {
    /**
     * 点赞：状态为1
     */
    void saveLiked2Redis(String likedUserId, String likedPostId);
    /**
     * 取消点赞  状态为0
     */
    void unlikeFromRedis(String likedUserId, String likedPostId);

    /**
     * 从redis中删除一条数据
     */
    void deleteLikedFromRedis(String likedUserId, String likedPostId);

    /**
     * 该用户的点赞数加1
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
