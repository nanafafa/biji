package com.riji.article.service;

import com.riji.article.dao.CommentRepository;
import com.riji.article.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨鹏发
 * @date 2020/6/7 0007
 */
@Service
public class CommentServiceImpl {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存一个评论
     */
    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }
    /**
     * 更新一个评论
     */
    public void updateComment(Comment comment){
        commentRepository.save(comment);
    }
    /**
     * 根据id删除评论
     */
    public void deleteCommentById(String id){
        //调用dao
        commentRepository.deleteById(id);
    }
    /**
     * 查询所有评论
     */
    public List<Comment> findCommentList(){
       return commentRepository.findAll();
    }
    /**
     * 根据文章id查询页面
     */
    public Page<Comment> findCommentListByParentid(String parentid,int page,int size){
        return commentRepository.findByParentid(parentid, PageRequest.of(page-1,size));

    }

    public void updateCommentLikeNum(String id){
        //quere查询条件
        Query query = Query.query(Criteria.where("_id").is(id));
        //update更新条件
        Update update = new Update();
        update.inc("likenum");
        mongoTemplate.updateFirst(query,update,Comment.class);

    }
}
