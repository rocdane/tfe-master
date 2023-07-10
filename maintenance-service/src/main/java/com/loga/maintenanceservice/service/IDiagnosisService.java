package com.loga.maintenanceservice.service;

import com.loga.maintenanceservice.entity.Diagnosis;

public interface IDiagnosisService {

    Diagnosis create(Diagnosis diagnosis);

    Diagnosis read(Long id);
}
