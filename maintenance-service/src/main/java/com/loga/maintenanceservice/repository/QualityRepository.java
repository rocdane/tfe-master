package com.loga.maintenanceservice.repository;

import com.loga.maintenanceservice.entity.Quality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualityRepository extends JpaRepository<Quality,Long> {

    Quality findByReference(String reference);
}
