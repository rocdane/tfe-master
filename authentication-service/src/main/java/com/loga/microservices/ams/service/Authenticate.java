package com.loga.microservices.ams.service;

import com.loga.microservices.ams.repository.UserRepository;
import com.loga.microservices.ams.vendor.security.Crypto;
import com.loga.microservices.ams.entity.AuthSession;
import com.loga.microservices.ams.entity.User;
import com.loga.microservices.ams.repository.AuthSessionRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

/**
 * @author rochdane sabi
 * @email rocdanesabi@gmail.com
 * @version 2.1.1
 */
@Service
public class Authenticate implements IAuthenticate {

    private final UserRepository userRepository;
    private final AuthSessionRepository authSessionRepository;

    @Autowired
    public Authenticate(UserRepository userRepository, AuthSessionRepository authSessionRepository) {
        this.userRepository = userRepository;
        this.authSessionRepository = authSessionRepository;
    }

    @Override
    public User signUp(User user) {

        boolean userExist = userRepository.findByUsername(user.getUsername())
                .isPresent();

        if(userExist){
            throw new IllegalStateException("Utilisateur existant");
        }

        String encodedPassword;

        try {
            encodedPassword = Crypto.getInstance().encrypt(user.getPassword());
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidAlgorithmParameterException |
                 InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }

        user = new User(user.getUsername(),encodedPassword);
        user.setRole(user.getRole());

        return userRepository.save(user);
    }

    @Override
    public User find(User user) {
        return userRepository.findByUsername(user.getUsername()).orElse(null);
    }

    @Override
    public List<User> allUser() {
        return userRepository.findAll();
    }

    /**
     * TODO: cette méthode permet de créer un objet Session pour un utilisateur.
     *
     * @param user
     * @return AuthSession
     */
    @SneakyThrows
    @Override
    public AuthSession signIn(User user) {

        user = userRepository
                .findByUsernameAndPassword(user.getUsername(),
                        Crypto.getInstance().encrypt(user.getPassword()))
                .orElse(user);

        AuthSession authSession = null;

        if(user.getActive()){
            authSession = new AuthSession();
            authSession.setClosed(false);
            authSession.setCreatedAt(new Date());
            authSession.setUser(user);
            authSessionRepository.saveAndFlush(authSession);
        }

        return authSession;
    }

    @Override
    public AuthSession check(String token){
        return authSessionRepository.findByToken(token);
    }

    /**
     * TODO:Cette méthode permet de détruire un objet Session d'un utilisateur.
     * @param token
     */
    @Override
    public void logout(String token) {
        AuthSession authSession = authSessionRepository.findByToken(token);
        authSession.setClosedAt(new Date());
        authSession.setClosed(true);
        authSessionRepository.save(authSession);
    }

    /**
     * TODO: Cette méthode permet de mettre à jour un objet User.
     * @param user, id
     */
    @Override
    public void updateUser(User user, Long id){
        userRepository
            .findById(id)
            .ifPresent(up -> {
                up.setUsername(user.getUsername());
                try {
                    up.setPassword(Crypto.getInstance().encrypt(user.getPassword()));
                } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidAlgorithmParameterException |
                         InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
                    throw new RuntimeException(e);
                }
                userRepository.saveAndFlush(up);
            });
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
