package com.loga.maintenanceservice.repository;

import com.loga.maintenanceservice.entity.Reception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionRepository extends JpaRepository<Reception,Long> {
    Reception findByReference(String reference);
}
