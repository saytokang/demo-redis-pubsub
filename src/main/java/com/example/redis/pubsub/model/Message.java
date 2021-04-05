package com.example.redis.pubsub.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String payload;
    private String sender;
}
