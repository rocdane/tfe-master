package com.loga.microservices.ams.controller;

import com.loga.microservices.ams.entity.AuthSession;
import com.loga.microservices.ams.entity.User;
import com.loga.microservices.ams.service.Authentication;
import org.bouncycastle.util.IPAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/authentication-service")
public class AuthenticationController {

    @Autowired
    private Authentication authentication;

    @PostMapping(path = "/signin", produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthSession authenticate(@RequestBody User user){
        return authentication.auth(user);
    }

    @PostMapping(path = "/registrate", produces = MediaType.APPLICATION_JSON_VALUE)
    public User register(@RequestBody User user){
        return authentication.register(user);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@RequestBody User user, @PathVariable Long id){
        authentication.update(user,id);
    }

    @PostMapping(path = "/logout/{token}")
    public void logout(@PathVariable String token){
        authentication.logout(token);
    }

    @GetMapping(path = "/session/{token}",produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthSession checkSession(@PathVariable String token){
        return authentication.fetchSession(token);
    }
}
