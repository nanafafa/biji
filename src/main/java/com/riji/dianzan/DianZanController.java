package com.riji.dianzan;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏发
 * @date 2020/2/3 0003
 */
@RestController
@Api(description = "点赞")
public class DianZanController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private LikedService likedService;

    @PostMapping("/like")
    @ApiOperation("点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "likedUserId", value = "被点赞的用户id"),
            @ApiImplicitParam(name = "likedPostId", value = "点赞的用户id")
    })
    public ResultVO like(@RequestParam("likedUserId")String likedUserId, @RequestParam("likedPostId") String likedPostId){
        //先把数据存到redis中，在定时存到数据库
        redisService.saveLiked2Redis(likedUserId,likedPostId);
        redisService.incrementLikedCount(likedUserId);

        return ResultVOUtils.success();
    }

    @GetMapping("/saveDianZan")//@RequestParam("likedUserId")String likedUserId, @RequestParam("likedPostId") String likedPostId
    public ResultVO saveDian(){
        UserLike userLike = new UserLike();
        userLike.setLikedUserId("fafa");
        userLike.setLikedPostId("nana");
        userLike.setStatus(1);
        likedService.save(userLike);
        return ResultVOUtils.success();
    }

}
