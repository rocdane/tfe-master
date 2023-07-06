package com.loga.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.loga.customerservice.entity.Dossier;

import java.util.List;

@Repository
public interface DossierRepository extends JpaRepository<Dossier,Long> {
    List<Dossier> findDossierByAutomobile(String immatriculation);
    Dossier findByReference(String reference);
}

