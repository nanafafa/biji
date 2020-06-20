package com.riji.article.po;

import lombok.Data;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 杨鹏发
 * @date 2020/6/7 0007
 */
@Data
@Document(collection="comment") //可以省略，如果省略，则默认使用类名小写映射集合
@CompoundIndex( def = "{'userid':1,'nickname':-1}")
public class Comment implements Serializable {
    //主键标识，该属性的值会自动对应mongodb的主键字段"_id",如果该属性名就叫"id"，则该注解可以省略，否则必须写
    @Id
    private String id;
    //该属性对应mongodb的字段的名字，如果一致，则无需该注解
    @Field("content")
    private String content;//吐槽内容

    private Date publishtime;//发布日期
    //添加一个单字段的索引
    @Indexed
    private String userid;//发布人ID  属性都是和mmongodb中的属性一一对应的，如果不对应需加上@Field注解
    private String nickname;
    private LocalDateTime createdatetime;//评论的日期时间
    private Integer likenum;//点赞数
    private Integer replynum;//回复数
    private String state;//状态
    private String parentid;//上级ID
    private String articleid;

}
