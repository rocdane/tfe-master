package com.loga.customerservice.service;

import com.loga.customerservice.entity.Dossier;

import java.util.List;

public interface IDossierService {

    Dossier createDossier(Dossier dossier);

    Dossier findDossier(Long id);

    Dossier findDossier(String reference);

    List<Dossier> listDossier();

    Dossier findDossierByAutomobile(String number);

    void editDossier(Dossier dossier, Long id);

    void deleteDossier(Long id);
}
