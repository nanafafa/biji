package com.riji.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author 杨鹏发
 * @date 2020/9/8 0008
 */
public class TestDate {
    private String name;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
