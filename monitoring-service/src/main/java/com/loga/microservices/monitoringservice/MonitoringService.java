package com.loga.microservices.monitoringservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MonitoringService {

	public static void main(String[] args) {
		SpringApplication.run(MonitoringService.class, args);
	}

}
