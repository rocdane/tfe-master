package com.loga.authenticationservice.vendor.config;

import com.loga.authenticationservice.entity.User;
import com.loga.authenticationservice.service.IAuthenticate;
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
    IAuthenticate authentication;
    @Bean
    CommandLineRunner init() {
        User user = new User("admin","secret");
        user.setRole("ADMIN");
        user.setActive(true);
        if(authentication.find(user)!=null)
            return args -> {
                log.info("Preloading !!!");
            };
        else
            return args -> {
                log.info("Preloading " + authentication.signUp(user));
            };
    }
}
