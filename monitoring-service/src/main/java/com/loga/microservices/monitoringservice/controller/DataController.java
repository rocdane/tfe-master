package com.loga.microservices.monitoringservice.controller;

import com.loga.microservices.monitoringservice.service.etl.IEtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/monitoring-service")
public class DataController {

    @Autowired
    private IEtlService etlService;

    @PutMapping(path = "/load-data/all")
    public void loadAllData(){
    }

    @PutMapping(path = "/load-data/customers")
    public void loadCustomerData(){
    }

    @PutMapping(path = "/load-data/maintenances")
    public void loadMaintenanceData(){
    }
}
