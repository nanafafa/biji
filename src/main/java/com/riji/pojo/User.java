package com.riji.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("bd_user")
public class User {
    private String id;

    //private String userName;

    private String user_mail;

    private String user_password;
//    @JsonFormat(pattern = "yyyy-MM-dd",timezone ="GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date ts;
//
//    private Integer dr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

//    public Date getTs() {
//        return ts;
//    }
//
//    public void setTs(Date ts) {
//        this.ts = ts;
//    }
//
//    public Integer getDr() {
//        return dr;
//    }
//
//    public void setDr(Integer dr) {
//        this.dr = dr;
//    }
}
