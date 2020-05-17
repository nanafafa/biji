package com.riji.scheduledDemo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 杨鹏发
 * @date 2020/5/7 0007
 */
//写一个简单的获取配置的Mock类，用来模拟配置竞争
public class ExecutiveLock {
    ConcurrentHashMap<String,String> lockMap =new ConcurrentHashMap<>();
    public static final ExecutiveLock instance = new ExecutiveLock();

    public ExecutiveLock() {
    }
    public boolean tryLock(String key,String lockVal){
        String old = lockMap.computeIfAbsent(key, (s) -> lockVal);
        return lockVal.equalsIgnoreCase(old);
    }
}
