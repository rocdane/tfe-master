package com.loga.microservices.ams.repository;

import com.loga.microservices.ams.entity.AuthSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthSessionRepository extends JpaRepository<AuthSession,Long> {
    AuthSession findByToken(String token);
}
