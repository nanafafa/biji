package com.riji.dianzan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 杨鹏发
 * @date 2020/2/3 0003
 */
@Service
public class LikedServiceImpl implements LikedService {
    @Autowired
    private UserLikeRepository userLikeRepository;
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserLike save(UserLike userLike) {
        UserLike userLike1 = userLikeRepository.save(userLike);
        return userLike1;
    }

    @Override
    @Transactional
    public List<UserLike> saveAll(List<UserLike> list) {

        return userLikeRepository.saveAll(list);
    }

    @Override
    public Page<UserLike> getLikedListByLikedUserId(String likedUserId, Pageable pageable) {
        return userLikeRepository.findByLikedUserIdAndStatus(likedUserId,LikedStatusEnum.LIKE.getCode(),pageable);
    }
    @Override
    public Page<UserLike> getLikedListByLikedPostId(String likedPostId, Pageable pageable) {
        return userLikeRepository.findByLikedPostIdAndStatus(likedPostId,LikedStatusEnum.LIKE.getCode(), pageable);
    }

    @Override
    public UserLike getByLikedUserIdAndLikedPostId(String likedUserId, String likedPostId) {
        return userLikeRepository.findByLikedPostIdAndStatus(likedUserId,likedPostId);
    }

    @Override
    @Transactional
    public void transLikedFromRedis2DB() {
        List<UserLike> list = redisService.getLikedDataFromRedis();
        for(UserLike like:list){
            //查询点赞人和被点赞人是否存在点赞记录
            UserLike user = getByLikedUserIdAndLikedPostId(like.getLikedUserId(), like.getLikedPostId());
            if(null==user){
                //没有记录，则直接存进去就可
                save(like);
            }else{
                //有记录，需要更新
                user.setStatus(like.getStatus());
                save(user);
            }

        }


    }

    @Override
    @Transactional
    public void transLikedCountFromRedis2DB() {
        List<LikedCountDTO> list = redisService.getLikedCountFromRedis();
        for (LikedCountDTO dto:list){
            UserInfo userInfo = userService.findById(dto.getId());
            if(null!=userInfo){
                Integer num=userInfo.getLikeNum()+dto.getCount();
                userInfo.setLikeNum(num);
                //更新点赞数量
                userService.updateInfo(userInfo);
            }

        }
    }
}
