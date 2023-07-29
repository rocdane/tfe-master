package com.loga.intelligentservice.app.api;

import com.loga.intelligentservice.app.factory.Diagnosis;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "gateway-server")
public interface MonitoringServiceProxy {

    @GetMapping(path = "/monitoring-service/diagnoses", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Diagnosis> getDianose();
}
