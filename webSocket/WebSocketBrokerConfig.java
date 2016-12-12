//Negative test for registering permissive allowed-origins for WebSocketHandlerRegistration class
//and StompEndpointRegistry class.

package com.programcreek.helloworld.controller;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.messaging.simp.config.*;

@Configuration
@EnableScheduling
@EnableWebSocketMessageBroker
public class WebSocketBrokerConfig extends AbstractWebSocketMessageBrokerConfigurer {

    //calling setAllowedOrigins on WebSocketHandlerRegistration instance
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        ((WebSocketHandlerRegistration) registry.addEndpoint("/messages")).setAllowedOrigins("/").withSockJS();
    }

    //calling setAllowedOrigins on StompEndpointRegistry instance
    protected void configureStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/foo").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
	registry.enableSimpleBroker("/queue/", "/topic/");
	registry.setApplicationDestinationPrefixes("/app");
    }
}
