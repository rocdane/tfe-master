package com.loga.maintenanceservice.repository;

import com.loga.maintenanceservice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NoticeRepository extends JpaRepository<Notice,Long> {
}
