package com.loga.customerservice.controller;

import com.loga.customerservice.entity.Client;
import com.loga.customerservice.exception.ClientNotFoundException;
import com.loga.customerservice.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer-service")
public class ClientController {

    @Autowired
    private IClientService manageClient;

    @PostMapping(path = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client newClient(@RequestBody Client client){
        return manageClient.createClient(client);
    }

    @GetMapping(path = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> readAll(){
        return manageClient.listClient();
    }

    @GetMapping(path = "/clients/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Client read(@PathVariable Long id){
        Client client = manageClient.findClient(id);
        if(client==null){
            throw new ClientNotFoundException(String.format("Impossible de trouver le client avec la clé : %d",id));
        }else {
            return client;
        }
    }

    @GetMapping(path = "/clients/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client readByName(@PathVariable String name){
        Client client = manageClient.findClient(name);
        if(client==null){
            throw new ClientNotFoundException(String.format("Impossible de trouver les infos du client avec la clé : %s",name));
        }else {
            return client;
        }
    }

    @PutMapping(path = "/clients/{id}")
    public void edit(@RequestBody Client client, @PathVariable Long id){
        manageClient.editClient(client,id);
    }

    @DeleteMapping(path = "/clients/{id}")
    public void delete(@PathVariable Long id){
        manageClient.deleteClient(id);
    }
}
