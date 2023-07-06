package com.loga.microservices.monitoringservice.repository;

import com.loga.microservices.monitoringservice.entity.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierRepository extends JpaRepository<Dossier,Long> {
    Dossier findByReference(String reference);
}

