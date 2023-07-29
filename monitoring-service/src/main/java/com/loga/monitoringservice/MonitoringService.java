package com.loga.monitoringservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class MonitoringService {

	public static void main(String[] args) {
		SpringApplication.run(MonitoringService.class, args);
	}

}
