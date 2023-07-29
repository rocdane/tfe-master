package com.loga.monitoringservice.controller;

import com.loga.monitoringservice.app.api.ReportServiceProxy;
import com.loga.monitoringservice.app.factory.Dashboard;
import com.loga.monitoringservice.app.factory.Diagnoses;
import com.loga.monitoringservice.exception.DataNotFoundException;
import com.loga.monitoringservice.exception.EtlFailedException;
import com.loga.monitoringservice.service.IMonitoring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/monitoring-service")
public class MonitoringController {

    @Autowired
    private IMonitoring monitoringService;

    @Autowired
    private ReportServiceProxy reportService;

    @PostMapping(path = "/etl")
    public void etl(){
        try {
            monitoringService.etl();
        } catch (InterruptedException | IOException | ExecutionException | TimeoutException e) {
            throw new EtlFailedException("Failed to process ETL job : \n"+e.getMessage());
        }
    }

    @GetMapping(path = "/load",produces = MediaType.APPLICATION_JSON_VALUE)
    public Dashboard load(){
        try {
            return monitoringService.load();
        } catch (SQLException e) {
            throw new DataNotFoundException("Failed to load dashboard data : "+e.getMessage());
        }
    }

    @GetMapping(path = "/diagnoses",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Diagnoses> diagnose(){
        try {
            return monitoringService.diagnose();
        } catch (SQLException e) {
            throw new DataNotFoundException("Failed to load diagnosies : "+e.getMessage());
        }
    }

    @PostMapping(path = "/report/{src}", produces = MediaType.APPLICATION_PDF_VALUE)
    public void report(@PathVariable String src) {
        reportService.report(src);
    }
}
