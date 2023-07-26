package com.loga.maintenanceservice.controller;

import com.loga.maintenanceservice.app.api.CustomerServiceProxy;
import com.loga.maintenanceservice.app.api.IntelligentServiceProxy;
import com.loga.maintenanceservice.app.api.ReportServiceProxy;
import com.loga.maintenanceservice.app.factory.Dossier;
import com.loga.maintenanceservice.entity.Diagnosis;
import com.loga.maintenanceservice.exception.RegistrationFailedException;
import com.loga.maintenanceservice.service.IDiagnosisService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/maintenance-service")
public class DiagnosisController {

    private final Logger logger = LoggerFactory.getLogger(DiagnosisController.class);

    @Autowired
    private IDiagnosisService repairDiagnostic;

    @Autowired
    private ReportServiceProxy reportService;

    @Autowired
    private CustomerServiceProxy customerProxy;

    @Autowired
    private IntelligentServiceProxy intelligentServiceProxy;

    @GetMapping(path = "/resolve/{words}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> processDiagnosis(@PathVariable String words){
        return intelligentServiceProxy.processDiagnosis(words);
    }

    @PostMapping(path = "/diagnosis", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Diagnosis> create(@RequestBody Diagnosis diagnosis) {
        Diagnosis created = repairDiagnostic.create(diagnosis);
        if(created!=null){
            return ResponseEntity.ok(created);
        }else {
            throw new RegistrationFailedException("Failed to registrate diagnosis.");
        }
    }

    @GetMapping(path = "/diagnosis", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Diagnosis> read() {
        return repairDiagnostic.readAll();
    }

    @GetMapping(path = "/diagnosis/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Diagnosis read(@PathVariable Long id) {
        return repairDiagnostic.read(id);
    }

    @GetMapping(path = "/report/diagnosis/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public void report(HttpServletResponse response, @PathVariable Long id) {
        reportService.produceReportById(response, "diagnosis", id);
    }

    @GetMapping(path = "/diagnosis/dossiers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CircuitBreaker(name = "customer-api", fallbackMethod = "fallBackResponse")
    public ResponseEntity<Dossier> retrieveDossier(@PathVariable Long id){
        logger.info("call customer api !!!");
        Dossier dossier = customerProxy.retrieveDossier(id);
        return ResponseEntity.ok(dossier);
    }

    public String fallBackResponse(Exception ex){
        return "Fall Back response : "+ex.getMessage();
    }
}
