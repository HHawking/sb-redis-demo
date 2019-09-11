package com.hhawking.redis.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
* @title: redis订阅
* @Author: HH
* @Date: 2019/7/31 10:57
*/
@Configuration
public class RedisListenerConfig {

    /**
     * 初始化监听器
     * @param connectionFactory
     * @param listenerAdapter
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("AAA"));
        return container;
    }

    /**
     * 利用反射来创建监听到消息之后的执行方法
     * @param redisService
     * @return
     */
    @Bean
    MessageListenerAdapter listenerAdapter(RedisService redisService) {
        return new MessageListenerAdapter(redisService, "onMessage");
    }
}