package com.loga.maintenanceservice.repository;

import com.loga.maintenanceservice.entity.Control;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ControlRepository extends JpaRepository<Control,Long> {
}
