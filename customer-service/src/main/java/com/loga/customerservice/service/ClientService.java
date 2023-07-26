package com.loga.customerservice.service;

import com.loga.customerservice.repository.ClientRepository;
import com.loga.customerservice.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Cette méthode permet d'enregistrer un objet Client dans la base de données. Elle retourne l'objet Client ainsi créé.
     * @param client
     * @return Client
     */
    @Override
    @Transactional
    public Client createClient(Client client) {
        if(clientRepository.findByContact(client.getContact())!=null)
            return null;
        else
            return clientRepository.save(client);
    }

    /**
     * Cette méthode permet de sélectionner les objets Client de la base de données dans une collection.
     * @return List
     */
    @Override
    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    /**
     * Cette méthode permet de sélectionner les objets Client de la base de données dans une collection.
     * @return List
     */
    @Override
    public List<Client> searchClient(String name) {
        return clientRepository.findAll();
    }

    /**
     * Cette méthode permet de sélectionner un objet Client de la base de données.
     * @param id
     * @return Client
     */
    @Override
    public Client findClient(long id) {
        Client client = null;
        if(clientRepository.findById(id).isPresent())
            client = clientRepository.findById(id).get();
        return client;
    }

    /**
     * Cette méthode permet de sélectionner un objet Client de la base de données.
     * @param name
     * @return Client
     */
    @Override
    public Client findClient(String name) {
        Client client = null;
        if(clientRepository.findByName(name).isPresent())
            client = clientRepository.findByName(name).get();
        return client;
    }

    /**
     * Cette méthode permet de mettre à jour un objet Client dans la base de données.
     * @param client, id
     */
    @Override
    @Transactional
    public void editClient(Client client, Long id) {
        clientRepository
                .findById(id) // returns Optional<User>
                .ifPresent(up -> {
                    up.setName(client.getName());
                    up.setAddress(client.getAddress());
                    up.setContact(client.getContact());
                    up.setType(client.getType());
                    up.setLegalNotice(client.getLegalNotice());
                    clientRepository.saveAndFlush(up);
                });
    }

    /**
     * Cette méthode permet de supprimer un objet Client de la base de données.
     * @param id
     */
    @Override
    @Transactional
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
