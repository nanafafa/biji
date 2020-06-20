package com.riji.article.dao;

import com.riji.article.po.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author 杨鹏发
 * @date 2020/6/7 0007
 */
public interface CommentRepository extends MongoRepository<Comment,String> {
    //按照规定的语法格式
    Page<Comment> findByParentid(String parentid, Pageable pageable);


}
