package com.loga.microservices.ams.vendor.config;

import com.loga.microservices.ams.entity.User;
import com.loga.microservices.ams.service.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Loader {

    private static final Logger log = LoggerFactory.getLogger(Loader.class);

    @Autowired
    Authentication authentication;

    @Bean
    CommandLineRunner init() {
        if(authentication.ifExist(new User("admin","secret"))!=null)
            return args -> {
                log.info("Preloading !!!");
            };
        else
            return args -> {
                log.info("Preloading " + authentication.register(new User("admin","secret")));
            };
    }
}
