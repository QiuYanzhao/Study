package com.my.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring redis Template 操作redis集群
 */
@RestController
public class SpringRedisCluster {

    /**
     * 集群配置在配置文件
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    public void testRedisCluster() {
        String o = (String)redisTemplate.opsForValue().get("test");
        System.err.println(o);
        boolean write_contact_incr = Boolean.getBoolean(o);
        System.err.println(write_contact_incr);

    }
}
