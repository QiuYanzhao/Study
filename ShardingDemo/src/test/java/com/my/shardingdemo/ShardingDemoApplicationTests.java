package com.my.shardingdemo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.my.shardingdemo.mapper")
class ShardingDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void splitTable() {
        System.err.println("test");
    }

}
