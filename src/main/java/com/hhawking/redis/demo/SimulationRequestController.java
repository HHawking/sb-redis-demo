package com.hhawking.redis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
* @title: 模拟请求
* @Author: HH
* @Date: 2019-9-11 15:38
*/
@Component
@EnableScheduling
public class SimulationRequestController {

    @Autowired
    private StringRedisTemplate template;

    /**
     * 定时器,每3秒向Redis通道发一条消息
     */
    @Scheduled(fixedRate = 3000)
    public void sendMessage(){
        String s = String.valueOf(Math.random());
        template.convertAndSend("AAA",s);
    }
}
