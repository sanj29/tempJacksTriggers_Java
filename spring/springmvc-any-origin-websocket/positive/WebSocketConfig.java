//Negative test for registering permissive allowed-origins for WebSocketHandlerRegistry class

package com.programcreek.helloworld.controller;

import org.springframework.context.annotation.*;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    //calling setAllowedOrigins on WebSocketHandlerRegistry instance
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
	registry.addHandler(myHandler(), "/myFoo").setAllowedOrigins("http://lawler.lawl").withSockJS();
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new MyHandler();
    }
}
