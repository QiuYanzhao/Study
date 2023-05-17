package com.my.redis.service;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * 展示redisson 的用法
 */

public class MyRedisson {

    /**
     * 配置参见RedissonConfig
     */
    @Autowired
    private Redisson redisson;

    public void myRedisson() {
        RLock lock = redisson.getLock("lockKey");
        try {
            lock.lock();
            // waitTime 等待获取锁的时间，leaseTime 持有锁的时间超过leaseTime会释放锁
            //lock.tryLock(10, 10, TimeUnit.SECONDS);
            //业务逻辑
        } catch (Exception e) {

        }finally {
            lock.unlock();
        }
    }

}
