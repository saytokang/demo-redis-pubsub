package com.example.redis.pubsub.service.listener;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Topic2ChannelListener {
    public void onMessage(String message) {
        log.info("[CH2: RECEIVED]==>{}", message);
    }
}
