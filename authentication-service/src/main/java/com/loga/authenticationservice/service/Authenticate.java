package com.loga.authenticationservice.service;

import com.loga.authenticationservice.entity.AuthSession;
import com.loga.authenticationservice.entity.User;
import com.loga.authenticationservice.exception.SessionErrorException;
import com.loga.authenticationservice.repository.UserRepository;
import com.loga.authenticationservice.vendor.security.Crypto;
import com.loga.authenticationservice.repository.AuthSessionRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Authenticate(UserRepository userRepository, AuthSessionRepository authSessionRepository) {
        this.userRepository = userRepository;
        this.authSessionRepository = authSessionRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User signUp(User user) {

        boolean userExist = userRepository.findByUsername(user.getUsername())
                .isPresent();

        if(userExist){
            throw new IllegalStateException("Utilisateur existant");
        }

        User added = new User(user.getUsername(),passwordEncoder.encode(user.getPassword()));

        added.setRole(user.getRole());

        return userRepository.save(added);
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
        try {
            User getted;

            if(userRepository.findByUsername(user.getUsername()).isPresent()){
                getted = userRepository.findByUsername(user.getUsername()).get();

                if(!passwordEncoder.matches(user.getPassword(), getted.getPassword())) {
                    throw new SessionErrorException("Password is not correct");
                }else{
                    if(!getted.getActive())
                        throw new SessionErrorException("Access not granted");
                }
            }else {
                throw new SessionErrorException("User not registred");
            }

            AuthSession authSession = new AuthSession();
            authSession.setClosed(false);
            authSession.setCreatedAt(new Date());
            authSession.setUser(getted);
            authSession = authSessionRepository.save(authSession);
            return authSession;

        }catch (Exception e){
            throw new SessionErrorException("Failed on session establishements: \n"+e.getMessage());
        }
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
