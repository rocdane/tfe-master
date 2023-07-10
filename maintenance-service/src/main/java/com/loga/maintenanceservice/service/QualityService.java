package com.loga.maintenanceservice.service;

import com.loga.maintenanceservice.entity.Quality;
import com.loga.maintenanceservice.repository.QualityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QualityService implements IQualityService {

    @Autowired
    private QualityRepository qualityRepository;


    /**
     * TODO:Cette méthode permet d'enregistrer un objet Qualite dans la base de données.
     * @param quality
     * @return Quality
     */
    @Override
    public Quality createQuality(Quality quality) {
        return qualityRepository.save(quality);
    }
}
