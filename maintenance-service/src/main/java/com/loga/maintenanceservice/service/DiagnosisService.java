package com.loga.maintenanceservice.service;

import com.loga.maintenanceservice.entity.Repair;
import com.loga.maintenanceservice.exception.RegistrationFailedException;
import com.loga.maintenanceservice.repository.DiagnosisRepository;
import com.loga.maintenanceservice.entity.Diagnosis;
import jdk.jshell.Diag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DiagnosisService implements IDiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    /**
     * TODO:Cette méthode permet d'enregistrer un objet Diagnostic dans la base de données.
     * @param diagnosis
     * @return Diagnosis
     */
    @Override
    @Transactional
    public Diagnosis create(Diagnosis diagnosis) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        diagnosis.setCreatedAt(new Date());
        diagnosis.setReference(sdf.format(diagnosis.getCreatedAt())+"-"+diagnosis.getDossier());
        return diagnosisRepository.save(diagnosis);
    }

    @Override
    public Diagnosis read(Long id) {
        if(diagnosisRepository.findById(id).isPresent())
            return diagnosisRepository.findById(id).get();
        return null;
    }

    @Override
    public List<Diagnosis> readAll() {
        return diagnosisRepository.findAll();
    }
}
