package com.loga.customerservice.vendor.config;

import com.loga.customerservice.entity.Client;
import com.loga.customerservice.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Loader {

    @Autowired
    private IClientService clientService;

    private static final Logger log = LoggerFactory.getLogger(Loader.class);

    @Bean
    CommandLineRunner init(){

        if(clientService.createClient(new Client("Rochdane SABI", "HOMME",
                        "rocdanesabi@n2a-consulting.com"))!=null)
            return args -> {
                log.info("Customer Service Initialization ---");
            };
        else
            return args -> {
                log.info("Customer Service Initialized !!!");
            };
    }
}
