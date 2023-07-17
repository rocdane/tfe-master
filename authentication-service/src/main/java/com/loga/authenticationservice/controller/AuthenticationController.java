package com.loga.authenticationservice.controller;

import com.loga.authenticationservice.entity.AuthSession;
import com.loga.authenticationservice.entity.User;
import com.loga.authenticationservice.exception.SessionErrorException;
import com.loga.authenticationservice.service.IAuthenticate;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/authentication-service")
public class AuthenticationController {

    @Autowired
    private IAuthenticate authentication;

    @PostMapping(path = "/signin", produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthSession authenticate(HttpServletRequest request, @RequestBody User user) {
        AuthSession authSession = authentication.signIn(user);
        if(authSession!=null){
            authSession.setHost(request.getRemoteAddr());
            return authSession;
        }
        else
            throw new SessionErrorException("Failed to establish session");
    }

    @PostMapping(path = "/registrate", produces = MediaType.APPLICATION_JSON_VALUE)
    public User register(@RequestBody User user){
        return authentication.signUp(user);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@RequestBody User user, @PathVariable Long id){
        authentication.updateUser(user,id);
    }

    @PostMapping(path = "/logout/{token}")
    public void logout(@PathVariable String token){
        authentication.logout(token);
    }

    @GetMapping(path = "/session/{token}",produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthSession checkSession(@PathVariable String token){
        return authentication.check(token);
    }
}