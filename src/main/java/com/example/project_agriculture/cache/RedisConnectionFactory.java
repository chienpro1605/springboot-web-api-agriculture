package com.example.project_agriculture.cache;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public final class RedisConnectionFactory {
    private static final int DEFAULT_TIMEOUT = 200000;
    private static JedisPool jedisPool;

    private RedisConnectionFactory() {
    }

    public static void init(String host, int port, String password) {
        jedisPool = new JedisPool(buildPoolConfig(), host, port, DEFAULT_TIMEOUT, password);
    }

    private static JedisPoolConfig buildPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(2000);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setMaxWaitMillis(Duration.ofSeconds(10L).toMillis());
        poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60L).toMillis());
        poolConfig.setSoftMinEvictableIdleTimeMillis(Duration.ofSeconds(120L).toMillis());
        poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30L).toMillis());
        poolConfig.setNumTestsPerEvictionRun(3);
        poolConfig.setBlockWhenExhausted(true);
        return poolConfig;
    }

    static JedisPool getPool() {
        return jedisPool;
    }
}