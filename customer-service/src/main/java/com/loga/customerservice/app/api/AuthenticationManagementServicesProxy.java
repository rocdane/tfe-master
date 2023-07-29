package com.loga.customerservice.app.api;

import com.loga.customerservice.app.factory.AuthSession;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "gateway-server")
public interface AuthenticationManagementServicesProxy {

    @GetMapping(path = "/authentication-service/session/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
    AuthSession fetchSession(@PathVariable String token);
}
