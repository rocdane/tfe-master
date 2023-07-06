package com.loga.microservices.ams.app.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "gateway-server")
public interface IntelligentServiceProxy {

    @PostMapping(path = "/intelligent-service/agent")
    public void create(@RequestBody String body);
}
