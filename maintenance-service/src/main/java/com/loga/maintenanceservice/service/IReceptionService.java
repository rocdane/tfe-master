package com.loga.maintenanceservice.service;


import com.loga.maintenanceservice.entity.Diagnosis;
import com.loga.maintenanceservice.entity.Reception;

import java.util.List;

public interface IReceptionService {

    Reception create(Reception reception);

    Reception read(Long id);

    List<Reception> readAll();
}
