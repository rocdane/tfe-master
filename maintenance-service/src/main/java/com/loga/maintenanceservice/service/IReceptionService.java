package com.loga.maintenanceservice.service;


import com.loga.maintenanceservice.entity.Reception;

public interface IReceptionService {

    Reception create(Reception reception);

    Reception read(Long id);
}
