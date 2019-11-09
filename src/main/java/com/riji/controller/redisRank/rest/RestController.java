package com.riji.controller.redisRank.rest;


import com.riji.controller.redisRank.component.RankListComponent;
import com.riji.controller.redisRank.component.RedisComponent;
import com.riji.controller.redisRank.model.RankDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author 杨鹏发
 * @date 2019/10/23 0023
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private RankListComponent rankListComponent;
    @Autowired
    private RedisComponent redisComponent;

    @GetMapping("/addScore")
    public String addSc(String key,String value,Float score){
        redisComponent.add(key,value,score);
        return "添加成功";
    }
    /**
     * 获取前N名的值
     */
    @GetMapping("/topn")
    public List<RankDO> showTopN(Long n){
        List<RankDO> topNRanks = rankListComponent.getTopNRanks(n);
        return topNRanks;
    }

    @GetMapping(path="/update")
    public RankDO updateScore(Long userid,Float score){
        return rankListComponent.updateRank(userid,score);
    }
    @GetMapping(path = "/rank")
    public RankDO queryRank(long userId) {
        return rankListComponent.getRank(userId);
    }

    @GetMapping(path = "/around")
    public List<RankDO> around(long userId, int n) {
        return rankListComponent.getRankAroundUser(userId, n);
    }
}
