package com.riji.dianzan;

/**
 * @author 杨鹏发
 * @date 2020/2/1 0001
 */
public class RedisKeyUtils {
    //保存用户点赞数据的key
    public static final String MAP_KEY_USER_LIKED = "MAP_USER_LIKED";
    //保存用户被点赞数量的key
    public static final String MAP_KEY_USER_LIKED_COUNT = "MAP_USER_LIKED_COUNT";

    /**
     * 拼接被点赞的用户id和点赞的人的id作为key。格式 222222::333333
     * @param likedUserId 被点赞的人id
     * @param likedPostId 点赞的人的id
     * @return
     */
    public static String getLikedKey(String likedUserId, String likedPostId){
        StringBuilder sb = new StringBuilder();
        sb.append(likedUserId);
        sb.append("::");
        sb.append(likedPostId);
        return sb.toString();
    }

}
