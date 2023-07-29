package com.loga.monitoringservice.app.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("gateway-server")
public interface ReportServiceProxy {
    @GetMapping(path = "/report-service/report/{src}",produces = MediaType.APPLICATION_PDF_VALUE)
    public void report(@PathVariable String src);
}
