package com.my.redis.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public Redisson redisson() {
        Config config = new Config();
        // redisson支持多种架构，这里展示单机架构配置方式
        config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(0);
        config.setLockWatchdogTimeout(10000);
        return (Redisson) Redisson.create(config);
    }
}
