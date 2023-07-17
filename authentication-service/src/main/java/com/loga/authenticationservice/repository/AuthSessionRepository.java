package com.loga.authenticationservice.repository;

import com.loga.authenticationservice.entity.AuthSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthSessionRepository extends JpaRepository<AuthSession,Long> {
    AuthSession findByToken(String token);
}
