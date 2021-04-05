package com.example.redis.pubsub.web;

import com.example.redis.pubsub.model.Message;
import com.example.redis.pubsub.service.MessagePublisher;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MessageController {
    
    private final MessagePublisher messagePublisher;

    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody Message message) {
        messagePublisher.publish(message);
        return ResponseEntity.ok().build();
    }
}
