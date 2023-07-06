package com.loga.microservices.ams.repository;

import com.loga.microservices.ams.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log,Long> {
}
