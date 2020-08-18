package com.yuan.fest.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("pro")
public class TestRedis {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("hahah","yingyingying");

//        System.out.println(valueOperations.get("laowang"));
    }

    @Test
    public void testRedis2(){
        ValueOperations valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("hahahssss","yingyingying");

//        System.out.println(valueOperations.get("laowang"));
    }

    @Test
    public void testRedis1(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object lll = valueOperations.get("laowang");
        System.out.println(lll);
    }
}
