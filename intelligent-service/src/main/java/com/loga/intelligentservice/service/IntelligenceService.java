package com.loga.intelligentservice.service;

import com.loga.intelligentservice.app.api.JenaAPI;
import com.loga.intelligentservice.app.api.MonitoringServiceProxy;
import com.loga.intelligentservice.app.factory.Diagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntelligenceService implements IIntelligenceService {

    @Autowired
    private MonitoringServiceProxy monitoringService;

    @Override
    public List<Diagnosis> resolve(String words) {
        return JenaAPI.query(words);
    }

    @Override
    @Scheduled(fixedRate = 10000)
    public void update() {
        List<Diagnosis> diagnoses = monitoringService.getDianose();
        JenaAPI.updateOntology(diagnoses);
    }
}
