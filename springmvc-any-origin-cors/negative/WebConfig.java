//negative example
//CORS is enabled in the Web Configuration with all defaults and is mapped to all routes
//By default all origins and GET, HEAD and POST methods are allowed.

package com.programcreek.helloworld.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
