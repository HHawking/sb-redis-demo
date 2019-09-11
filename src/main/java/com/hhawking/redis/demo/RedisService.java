package com.hhawking.redis.demo;

import org.springframework.stereotype.Component;

/**
* @title: redis消息监听类
* @Author: HH
* @Date: 2019/7/31 11:37
*/
@Component
public class RedisService {

    /**
     * 处理接收到的消息的方法
     * @param message 接收到的消息
     */
    public void onMessage(String message){
        System.out.println("收到消息:"+message);
    }
}
