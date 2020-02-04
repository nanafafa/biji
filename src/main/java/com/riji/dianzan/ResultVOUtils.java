package com.riji.dianzan;

/**
 * @author 杨鹏发
 * @date 2020/2/3 0003
 */
public class ResultVOUtils {
    public static ResultVO success(){
        ResultVO vo = new ResultVO(200,"成功",true);
        return vo;
    }
}
