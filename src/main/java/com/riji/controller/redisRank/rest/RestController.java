package com.riji.controller.redisRank.rest;


import com.riji.controller.redisRank.component.RankListComponent;
import com.riji.controller.redisRank.component.RedisComponent;
import com.riji.controller.redisRank.model.RankDO;
import io.swagger.annotations.ApiImplicitParams;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Random;

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
    private Random random;

    private RestTemplate restTemplate;
//    @Autowired
//    private RedisTemplate redisTemplate;

    @GetMapping(path = "/ceshi")
    public void init() {
//        random = new Random();
        restTemplate = new RestTemplate();
//
//
//        for (int i = 0; i < 30; i++) {
//            int  a=random.nextInt(1024);
//            double d=random.nextDouble() * 100;
            int a=98;
            restTemplate.getForObject("http://localhost:8080/update?userId=" + a+ "&score=" + 99.0,
                    String.class);
        }
//    }


//    @GetMapping(path = "/add")
//    public void add() {
//        String key="global_rank";
//        String value="java";
//        double score=100.0;
//        redisComponent.add(key,value,score);
//    }

    @GetMapping(path = "/topn")
    public List<RankDO> showTopN(int n) {

        return rankListComponent.getTopNRanks(n);
    }

    @GetMapping(path = "/update")
    public RankDO updateScore(String userId, float score) {

        return rankListComponent.updateRank(userId, score);
    }

    @GetMapping(path = "/rank")
    public RankDO queryRank(String userId) {
        return rankListComponent.getRank(userId);
    }

    @GetMapping(path = "/around")
    public List<RankDO> around(String userId, int n) {
        return rankListComponent.getRankAroundUser(userId, n);
    }

}
