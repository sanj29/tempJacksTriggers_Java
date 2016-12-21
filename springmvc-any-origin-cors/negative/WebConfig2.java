package com.programcreek.helloworld.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class WebConfig2 extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("PUT", "DELETE")
                .allowedHeaders("X-Key", "X-AuthToken", "X-User")
                .exposedHeaders("X-AuthToken", "X-Expression-Data")
                .allowCredentials(false).maxAge(3600);
    }
}
