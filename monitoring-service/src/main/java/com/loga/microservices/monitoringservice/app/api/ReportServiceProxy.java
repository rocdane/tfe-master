package com.loga.microservices.monitoringservice.app.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("gateway-server")
public interface ReportServiceProxy {
}
