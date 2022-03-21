package com.example.redis.pubsub.service.listener;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageListener {
    
    public void onMessage(String message) {
        log.info("[CH1: RECEIVED]==>{}", message);
    }
}
