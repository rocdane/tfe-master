package com.loga.maintenanceservice.repository;

import com.loga.maintenanceservice.entity.Spare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpareRepository extends JpaRepository<Spare,Long> {
}
