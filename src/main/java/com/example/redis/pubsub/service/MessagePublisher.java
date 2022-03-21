package com.example.redis.pubsub.service;

import com.example.redis.pubsub.config.RedisConfig;
import com.example.redis.pubsub.model.Message;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessagePublisher {

    private final RedisTemplate<String, Object> redisTemplate;

    public void publish_ch1(Message message) {
        redisTemplate.convertAndSend(RedisConfig.TOPIC, message);
        log.info("publis msg: {}", message);
    }

    public void publish_ch2(Message message) {
        redisTemplate.convertAndSend(RedisConfig.TOPIC2, message);
        log.info("publis msg: {}", message);
    }
    
}
