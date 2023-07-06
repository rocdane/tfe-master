package com.loga.microservices.ams.controller;

import com.loga.microservices.ams.app.api.IntelligentServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication-service")
public class IntelligentServiceProxyController {

    @Autowired
    private IntelligentServiceProxy serviceProxy;

    @PostMapping(path = "/intelligent-service/agent")
    public void create(@RequestBody String name){
        serviceProxy.create(name);
    }
}
