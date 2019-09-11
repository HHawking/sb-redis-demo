package com.hhawking.redis.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 使用 put 与 get
     */
    @Test
    public void testGet(){
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("AAA","BBB");
        String s = valueOperations.get("AAA");
        System.out.println(s);
    }

    /**
     * 使用 hPut 与 hGet
     */
    @Test
    public void testHash() {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("TER-010006", "AAA","AAA-AAA-AAA");
        hashOperations.put("TER-010006", "BBB","BBB-BBB-BBB");
        String s = hashOperations.get("TER-010006", "AAA");
        System.out.println(s);
    }

}
