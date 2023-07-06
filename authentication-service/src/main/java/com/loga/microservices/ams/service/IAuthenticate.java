package com.loga.microservices.ams.service;

import com.loga.microservices.ams.entity.AuthSession;
import com.loga.microservices.ams.entity.User;

import java.util.List;

/**
 * @author rochdane sabi rocdanesabi@gmail.com
 * @version 2.1
 */
public interface IAuthenticate {
    User signUp(User user);
    User find(User user);
    AuthSession signIn(User user);
    AuthSession check(String token);
    void logout(String token);
    void updateUser(User user, Long id);
    void deleteUser(Long id);
    List<User> allUser();
}