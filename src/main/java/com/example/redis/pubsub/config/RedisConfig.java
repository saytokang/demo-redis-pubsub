package com.example.redis.pubsub.config;

import com.example.redis.pubsub.service.listener.Toptic1ChannelListener;
import com.example.redis.pubsub.service.listener.Topic2ChannelListener;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {
    public static final String TOPIC = "channel-1";
    public static final String TOPIC2 = "channel-2";
    public static final String TOPIC3 = "channel-3";

    @Bean
    public RedisMessageListenerContainer messageListenerContainer(
        RedisConnectionFactory connectionFactory,
        @Qualifier("channel-1") MessageListenerAdapter channel1Listener,
        @Qualifier("channel-2") MessageListenerAdapter channel2Listener
        ) {
        RedisMessageListenerContainer listenerContainer = new RedisMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        listenerContainer.addMessageListener(channel1Listener, new ChannelTopic(TOPIC));
        listenerContainer.addMessageListener(channel2Listener, new ChannelTopic(TOPIC2));

        return listenerContainer;
    }

    @Bean(name = "channel-1")
    public MessageListenerAdapter channel1Listener(Toptic1ChannelListener listener) {
        return new MessageListenerAdapter(listener, "onMessage");
    }

    @Bean(name = "channel-2")
    public MessageListenerAdapter channel2Listener(Topic2ChannelListener listener) {
        return new MessageListenerAdapter(listener, "onMessage");
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);

        redisTemplate.setKeySerializer(RedisSerializer.string()); 
        redisTemplate.setValueSerializer(RedisSerializer.java()); 
        redisTemplate.setHashKeySerializer(RedisSerializer.string()); 
        redisTemplate.setHashValueSerializer(RedisSerializer.java()); 
      
        return redisTemplate;
    }


}
