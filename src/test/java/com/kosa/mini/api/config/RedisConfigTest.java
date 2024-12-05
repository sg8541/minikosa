package com.kosa.mini.api.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisConnectionTest {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Test
    void testRedisConnection() {
        assertNotNull(redisConnectionFactory, "RedisConnectionFactory should not be null");

        try {
            System.out.println("Testing Redis connection...");
            var connection = redisConnectionFactory.getConnection(); // Redis 연결 시도
            assertNotNull(connection, "Connection should not be null");
            System.out.println("Redis connection successful!");
            connection.close(); // 연결 닫기
        } catch (Exception e) {
            fail("Unable to connect to Redis: " + e.getMessage());
        }
    }
}

