package com.riji.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 杨鹏发
 * @date 2021/1/18 0018
 */
@Component
@ConfigurationProperties(prefix = "testperpro")
public class TestProper {
    private Map<String,Object> maps;

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }
}
