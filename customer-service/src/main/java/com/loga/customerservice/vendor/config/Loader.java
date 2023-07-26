package com.loga.customerservice.vendor.config;

import com.loga.customerservice.entity.Automobile;
import com.loga.customerservice.entity.Client;
import com.loga.customerservice.entity.Dossier;
import com.loga.customerservice.service.IClientService;
import com.loga.customerservice.service.IDossierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Loader {

    @Autowired
    private IDossierService dossierService;

    private static final Logger log = LoggerFactory.getLogger(Loader.class);

    @Bean
    CommandLineRunner init(){

        Client client = new Client();
        client.setAddress("Africa");
        client.setContact("rochdanesabi@n2a.cc");
        client.setType("HOMME");
        client.setName("Rochdane SABI");
        client.setLegalNotice("Freelance");

        Automobile automobile = new Automobile();
        automobile.setMake("TOYOTA");
        automobile.setModel("Carina 3");
        automobile.setUnit("KM");
        automobile.setTrim(251233);
        automobile.setVin("ABCDEFGHJKLMNPRST");
        automobile.setNumber("AH2775RB");

        Dossier dossier = new Dossier();
        dossier.setReference(automobile.getNumber()+"-"+automobile.getVin());
        dossier.setClient(client);
        dossier.setAutomobile(automobile);

        Dossier created = dossierService.createDossier(dossier);

        if(created!=null)
            return args -> {
                log.info("Customer Service Initialization ---");
            };
        else
            return args -> {
                log.info("Customer Service Initialized !!!");
            };
    }
}
