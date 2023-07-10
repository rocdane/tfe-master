package com.loga.maintenanceservice.vendor.config;

import com.loga.maintenanceservice.entity.Diagnosis;
import com.loga.maintenanceservice.entity.Factor;
import com.loga.maintenanceservice.service.IDiagnosisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class Loader {

    @Autowired
    private IDiagnosisService diagnosisService;

    private static final Logger log = LoggerFactory.getLogger(Loader.class);

    @Bean
    CommandLineRunner init(){

        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDossier("dossier");
        diagnosis.setDescription("Diagnostic complet du véhicule");
        diagnosis.setMileage(234944);
        diagnosis.setReference(new SimpleDateFormat("yyyy-MM-dd").format(new Date())+diagnosis.getDossier());
        diagnosis.setProfile("Technicien Automobile");

        diagnosis.addFactor(new Factor("Système de motorisation",
                "courroie alternateur usée",
                "remplacement de la courroie alternateur"));

        diagnosis.addFactor(new Factor("Système de transmission",
                "transmission avant droit défectueux",
                "remplacement de la transmission avant droit"));

        diagnosis.addFactor(new Factor("Système de freinage",
                "vibration du volant au freinage",
                "contrôle et réglage des disques de freins"));

        diagnosis.addFactor(new Factor("Système de freinage",
                "plaquettes freins avant et arrière défectueux",
                "remplacement des plaquettes freins avant et arrière"));

        diagnosis.addFactor(new Factor("Système de suspension",
                "biellette barre stabilisatrice arrière usée",
                "remplacement des biellettes barre stabilisatrice arrière"));

        diagnosis.addFactor(new Factor("Système de direction",
                "rotule de direction défectueux",
                "remplacement du rotule de direction"));

        if(diagnosisService.create(diagnosis) != null) {

            return args -> {
                log.info("Maintenance Service Initialization ----");
            };
        }
        else
            return args -> {
                log.info("Maintenance Service Initialized !!!");
            };
    }
}
