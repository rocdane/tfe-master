package com.loga.customerservice.service;


import com.loga.customerservice.entity.Client;

import java.util.List;

public interface IClientService {
    Client createClient(Client client);
    List<Client> listClient();
    List<Client> searchClient(String name);
    Client findClient(long id);
    Client findClient(String name);
    void editClient(Client client, Long id);
    void deleteClient(Long id);
}
