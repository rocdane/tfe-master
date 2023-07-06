package com.loga.customerservice.service;

import com.loga.customerservice.repository.AutomobileRepository;
import com.loga.customerservice.entity.Automobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutomobileService implements IAutomobileService {
    @Autowired
    private AutomobileRepository automobileRepository;

    /**
     * Cette méthode permet d'enregistrer un objet Automobile dans la base de données. Elle retourne l'objet Automobile ainsi créé.
     * @param automobile
     * @return Automobile
     */
    @Override
    @Transactional
    public Automobile createAutomobile(Automobile automobile) {
        return automobileRepository.save(automobile);
    }

    @Override
    public List<Automobile> listAutomobile() {
        return automobileRepository.findAll();
    }

    /**
     * Cette méthode permet de sélectionner tous les objets Automobile de la base de données dans une collection.
     * @return List
     */
    @Override
    public List<Automobile> listAutomobile(Long client) {
        return automobileRepository.findAll();
    }

    /**
     * Cette méthode permet de sélectionner tous les objets Automobile de la base de données dans une collection.
     * @return List
     */
    @Override
    public List<Automobile> listAutomobile(String immatriculation) {
        return automobileRepository.findAllByNumberContaining(immatriculation);
    }

    /**
     * Cette méthode permet de sélectionner un objet Automobile de la base de données.
     * @param id
     * @return Automobile
     */
    @Override
    public Automobile findAutomobile(Long id) {
        return automobileRepository.findById(id).get();
    }

    /**
     * Cette méthode permet de sélectionner un objet Automobile de la base de données.
     * @param immatriculation
     * @return Automobile
     */
    @Override
    public Automobile findAutomobile(String immatriculation) {
        return automobileRepository.findByNumber(immatriculation).get();
    }

    /**
     * Cette méthode permet de mettre à jour un objet Automobile de la base de données.
     * @param id
     */
    @Override
    @Transactional
    public void editAutomobile(Automobile automobile, Long id) {
        automobileRepository
                .findById(id) // returns Optional<User>
                .ifPresent(up -> {
                    up.setVin(automobile.getVin());
                    up.setNumber(automobile.getNumber());
                    up.setMake(automobile.getMake());
                    up.setModel(automobile.getModel());
                    up.setTrim(automobile.getTrim());
                    up.setUnit(automobile.getUnit());
                    automobileRepository.saveAndFlush(up);
                });
    }

    /**
     * Cette méthode permet de supprimer un objet Automobile de la base de données.
     * @param automobile
     */
    @Override
    @Transactional
    public void deleteAutomobile(Long automobile) {
        automobileRepository.deleteById(automobile);
    }
}
