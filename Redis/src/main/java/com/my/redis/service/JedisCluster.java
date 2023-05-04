package com.my.redis.service;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;

/**
 * jedis 操作redis集群示例
 */
public class JedisCluster {
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMinIdle(5);

        HashSet<HostAndPort> hostAndPorts = new HashSet<>();
        hostAndPorts.add(new HostAndPort("192.168.1.3", 6379));
        hostAndPorts.add(new HostAndPort("192.168.1.3", 6380));
        hostAndPorts.add(new HostAndPort("192.168.1.3", 6381));

        redis.clients.jedis.JedisCluster jedisCluster =
                new redis.clients.jedis.JedisCluster(hostAndPorts, 6000, 5000, 10, config);
        System.err.println("构建完毕");
        System.err.println(jedisCluster.set("testK", "testV"));
        System.err.println(jedisCluster.get("testK"));
        System.err.println(jedisCluster.del("testK"));
    }
}
