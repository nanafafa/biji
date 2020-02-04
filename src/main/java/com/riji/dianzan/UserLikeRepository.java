package com.riji.dianzan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 杨鹏发
 * @date 2020/2/3 0003
 */
public interface UserLikeRepository extends JpaRepository<UserLike,Integer> {
    Page<UserLike> findByLikedUserIdAndStatus(String likedUserId,Integer code, Pageable pageable);
    
    UserLike findByLikedPostIdAndStatus(String likedUserId, String likedPostId);

    Page<UserLike> findByLikedPostIdAndStatus(String likedPostId, Integer code, Pageable pageable);
}
