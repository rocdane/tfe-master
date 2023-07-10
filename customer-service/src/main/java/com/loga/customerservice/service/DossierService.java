package com.loga.customerservice.service;

import com.loga.customerservice.entity.Dossier;
import com.loga.customerservice.repository.DossierRepository;
import com.loga.customerservice.entity.Automobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DossierService implements IDossierService {

    @Autowired
    private DossierRepository dossierRepository;

    /**
     * TODO:Cette méthode permet d'enregistrer un objet Dossier dans la base de données.
     * @param dossier
     * @return Dossier
     * @see Automobile , Client
     */
    @Override
    @Transactional
    public Dossier createDossier(Dossier dossier) {
        if(dossierRepository.findDossierByAutomobileNumber(dossier.getAutomobile().getNumber()).isEmpty() ||
         dossierRepository.findByReference(dossier.getReference())==null){
            dossier.setOpenAt(new Date());
            dossier.setUpdatedAt(new Date());
            return dossierRepository.save(dossier);
        }else
            return null;
    }

    /**
     * Cette méthode permet de sélectionner tous les objets Dossier de la base de données.
     *
     * @return List
     */
    @Override
    public List<Dossier> listDossier() {
        return dossierRepository.findAll();
    }

    /**
     * Cette méthode permet de sélectionner tous les objets Dossier de la base de données.
     * @param immatriculation
     * @return List
     */
    @Override
    public List<Dossier> listDossier(String immatriculation) {
        return dossierRepository.findDossierByAutomobileNumber(immatriculation);
    }

    /**
     * Cette méthode permet de sélectionner un objet Dossier de la base de données.
     * @param id
     * @return Dossier
     */
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

    /**
     * Cette méthode permet de supprimer un objet Dossier de la base de données.
     * @param dossier
     */
    @Override
    public void deleteDossier(Long dossier) {
        dossierRepository.deleteById(dossier);
    }
}
