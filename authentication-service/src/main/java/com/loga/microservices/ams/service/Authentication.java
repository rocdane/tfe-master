package com.loga.microservices.ams.service;

import com.loga.microservices.ams.entity.AuthSession;
import com.loga.microservices.ams.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Authentication service
 * @author rochdane sabi
 * @email rocdanesabi@gmail.com
 * @version 2.1.1
 * @since 2.0.1
 */
@Service
public class Authentication {

    @Autowired
    private IAuthenticate authenticate;

    /**
     * authenticate method
     * @param user
     * @return session's token
     */
    public AuthSession auth(User user){
        return authenticate.signIn(user);
    }

    /**
     * authenticate method
     * @param user
     * @return User
     */
    public User ifExist(User user){
        return authenticate.find(user);
    }

    /**
     * register method
     * @param user
     * @return User
     */
    public User register(User user){
        User existed = ifExist(user);
        if(existed==null){
            return authenticate.signUp(user);
        }else{
            authenticate.updateUser(user,existed.getId());
        }
        return user;
    }

    /**
     * register method
     * @param user
     * @return created User
     */
    public void update(User user,Long id){
        authenticate.updateUser(user,id);
    }

    /**
     * register method
     * @param token
     */
    public void logout(String token){
         authenticate.logout(token);
    }

    public AuthSession fetchSession(String token) {
        return authenticate.check(token);
    }
}
