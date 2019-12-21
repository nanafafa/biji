package com.riji.redissuo;

/**
 * @author 杨鹏发
 * @date 2019/11/28 0028
 */

import redis.clients.jedis.Jedis;

/**
 * 加锁操作
 */
public class jiasuo {
    Jedis jedis = new Jedis("127.0.0.1", 6379);
    private static final String success="ok";
    /**
     * 加锁操作
     * * @param key 锁标识
     *
     *   * @param value 客户端标识
     *
     *   * @param timeOut 过期时间
     */
    public Boolean lock(String key,String value,Long timeOut){

       // String var1 = jedis.set(key,value,"NX","EX",timeOut);

//        if(LOCK_SUCCESS.equals(var1)){
//
//            return true;
//
//        }

        return false;

    }


}
