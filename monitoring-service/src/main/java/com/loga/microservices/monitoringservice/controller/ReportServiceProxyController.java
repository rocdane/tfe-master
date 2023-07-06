package com.loga.microservices.monitoringservice.controller;

import com.loga.microservices.monitoringservice.app.api.ReportServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitoring-service")
public class ReportServiceProxyController implements ReportServiceProxy {

    @Autowired
    private ReportServiceProxy reportServiceProxy;
}
