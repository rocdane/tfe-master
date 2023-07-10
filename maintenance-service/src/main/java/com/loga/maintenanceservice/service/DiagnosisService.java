package com.loga.maintenanceservice.service;

import com.loga.maintenanceservice.repository.DiagnosisRepository;
import com.loga.maintenanceservice.entity.Diagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
        if(diagnosisRepository.findByReference(diagnosis.getReference())!=null)
            return null;

        diagnosis.setCreatedAt(new Date());
        return diagnosisRepository.save(diagnosis);
    }

    @Override
    public Diagnosis read(Long id) {
        if(diagnosisRepository.findById(id).isPresent())
            return diagnosisRepository.findById(id).get();

        return null;
    }
}
