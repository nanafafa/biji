package com.riji.article.service;

import com.riji.article.po.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 杨鹏发
 * @date 2020/6/7 0007
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCommentServiceImpl {

    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @Test
    public void testFindCommentList(){
        List<Comment> commentList = commentServiceImpl.findCommentList();
        System.out.println(commentList);
    }

    @Test
    public void testSaveComment(){
        Comment comment = new Comment();
        comment.setId("1001");
        comment.setArticleid("100000");
        comment.setContent("测试数据");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1003");
        comment.setNickname("凯撒大帝");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);
        commentServiceImpl.saveComment(comment);
    }
    @Test
    public void findCommentListByParentid(){
        Page<Comment> page = commentServiceImpl.findCommentListByParentid("3", 1, 2);
        System.out.println(page.getTotalElements());
        System.out.println(page.getContent());
    }



}
