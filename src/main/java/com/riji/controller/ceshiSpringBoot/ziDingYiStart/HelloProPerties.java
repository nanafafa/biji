package com.riji.controller.ceshiSpringBoot.ziDingYiStart;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 杨鹏发
 * @date 2020/5/16 0016
 */
//@Component  //和配置文件属性注入的时候必须有，自定义starter不用
@ConfigurationProperties(prefix = "fage.hello")
public class HelloProPerties {
    private String prefix;

    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
