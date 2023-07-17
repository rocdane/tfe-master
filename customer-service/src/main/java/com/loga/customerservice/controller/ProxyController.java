package com.loga.customerservice.controller;

import com.loga.customerservice.app.api.AuthenticationManagementServicesProxy;
import com.loga.customerservice.app.factory.AuthSession;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer-service")
public class ProxyController {

    @Autowired
    private AuthenticationManagementServicesProxy proxy;

    private final Logger logger = LoggerFactory.getLogger(ProxyController.class);

    @GetMapping(path = "/session/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CircuitBreaker(name = "authentication-api", fallbackMethod = "fallBackResponse")
    public ResponseEntity<AuthSession> authenticate(@PathVariable String token){
        logger.info("call authentication api !!!");
        AuthSession session = proxy.fetchSession(token);
        return ResponseEntity.ok(session);
    }

    public String fallBackResponse(Exception ex){
        return "Fall Back response : "+ex.getMessage();
    }
}
