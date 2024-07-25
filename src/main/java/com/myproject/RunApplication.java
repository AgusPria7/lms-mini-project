package com.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class RunApplication {
    
    private static final Logger logger = LoggerFactory.getLogger(RunApplication.class);
    
    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);
    }
    
     @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
