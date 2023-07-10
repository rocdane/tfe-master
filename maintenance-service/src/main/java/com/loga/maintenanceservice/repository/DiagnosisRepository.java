package com.loga.maintenanceservice.repository;

import com.loga.maintenanceservice.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis,Long> {

    Diagnosis findByReference(String reference);
}
