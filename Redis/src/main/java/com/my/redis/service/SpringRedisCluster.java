package com.my.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring redis Template 操作redis集群
 */
@RestController
public class SpringRedisCluster {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test")
    public void testRedisCluster() {
        ValueOperations<String, String> stringStringValueOperations =
                stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("testK", "testV");
        for (int i = 0; i < 20; i++) {
            System.err.println(stringStringValueOperations.get("testK"));
        }

    }
}
