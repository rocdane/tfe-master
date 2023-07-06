package com.loga.customerservice.service;

import com.loga.customerservice.entity.Automobile;

import java.util.List;

public interface IAutomobileService {
    Automobile createAutomobile(Automobile automobile);
    List<Automobile> listAutomobile();
    List<Automobile> listAutomobile(Long client);
    List<Automobile> listAutomobile(String immatriculation);
    Automobile findAutomobile(Long id);
    Automobile findAutomobile(String immatriculation);
    void editAutomobile(Automobile automobile, Long id);
    void deleteAutomobile(Long id);
}
