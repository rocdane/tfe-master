package com.loga.customerservice.service;

import com.loga.customerservice.entity.Client;
import com.loga.customerservice.entity.Dossier;
import com.loga.customerservice.repository.ClientRepository;
import com.loga.customerservice.repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DossierService implements IDossierService {

    @Autowired
    private DossierRepository dossierRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public Dossier createDossier(Dossier dossier) {
        Client client = null;

        if(clientRepository.findByName(dossier.getClient().getName()).isPresent()) {
            client = clientRepository.findByName(dossier.getClient().getName()).get();
        }

        if (client!=null) {
            System.out.println(client);
            dossier.setClient(client);
        }

        Boolean notExistAutomobile = dossierRepository.findDossierByAutomobileNumber(dossier.getAutomobile().getNumber()) == null;
        Boolean notExistReference = dossierRepository.findByReference(dossier.getReference()) == null;

        if(notExistAutomobile && notExistReference){
            dossier.setOpenAt(new Date());
            dossier.setUpdatedAt(new Date());
            return dossierRepository.save(dossier);
        }else{
            return null;
        }
    }

    @Override
    public List<Dossier> listDossier() {
        return dossierRepository.findAll();
    }

    @Override
    public Dossier findDossierByAutomobile(String number) {
        return dossierRepository.findDossierByAutomobileNumber(number);
    }

    @Override
    public Dossier findDossier(Long id) {
        return dossierRepository.findById(id).isPresent() ? dossierRepository.findById(id).get() : null;
    }

    @Override
    public Dossier findDossier(String reference){
        return dossierRepository.findByReference(reference);
    }

    @Override
    @Transactional
    public void editDossier(Dossier dossier, Long id){
        dossierRepository
                .findById(id) // returns Optional<User>
                .ifPresent(up -> {
                    up.setReference(dossier.getReference());
                    up.setUpdatedAt(new Date());
                    dossierRepository.saveAndFlush(up);
                });
    }

    @Override
    public void deleteDossier(Long dossier) {
        dossierRepository.deleteById(dossier);
    }
}
