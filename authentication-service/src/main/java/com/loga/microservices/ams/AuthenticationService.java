package com.loga.microservices.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("com.loga.microservices.ams")
public class AuthenticationService {
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationService.class, args);
	}

}
