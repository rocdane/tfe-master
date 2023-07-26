package com.loga.maintenanceservice.service;

import com.loga.maintenanceservice.entity.Diagnosis;
import com.loga.maintenanceservice.entity.Repair;

import java.util.List;

public interface IDiagnosisService {

    Diagnosis create(Diagnosis diagnosis);

    Diagnosis read(Long id);

    List<Diagnosis> readAll();
}
