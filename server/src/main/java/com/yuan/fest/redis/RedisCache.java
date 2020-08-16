package com.yuan.fest.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCache {
    @Autowired
    private RedisTemplate redisTemplate;

}
