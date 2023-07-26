package com.loga.customerservice.controller;

import com.loga.customerservice.entity.Dossier;
import com.loga.customerservice.exception.RegistrationFailedException;
import com.loga.customerservice.service.IDossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer-service")
public class DossierController {

    @Autowired
    private IDossierService manageDossierService;

    @PostMapping(path = "/dossiers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dossier> create(@RequestBody Dossier dossier){
        dossier.setReference(dossier.getAutomobile().getNumber()+"-"+dossier.getAutomobile().getVin());
        Dossier created = manageDossierService.createDossier(dossier);
        if(created!=null){
            return ResponseEntity.ok(created);
        }else {
            throw new RegistrationFailedException("Failed to registrate dossier");
        }
    }

    @GetMapping(path = "/dossiers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dossier>> readAll(){
        return ResponseEntity.ok(manageDossierService.listDossier());
    }

    @GetMapping(path = "/dossiers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dossier read(@PathVariable Long id){
        return manageDossierService.findDossier(id);
    }

    @GetMapping(path = "/dossiers/number/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dossier readByAutomobile(@PathVariable String number){
        return manageDossierService.findDossierByAutomobile(number);
    }

    @GetMapping(path = "/dossiers/reference/{reference}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dossier readByReference(@PathVariable String reference){
        return manageDossierService.findDossier(reference);
    }

    @PutMapping(path = "/dossiers/{id}")
    public void edit(@RequestBody Dossier dossier, Long id){
        manageDossierService.editDossier(dossier,id);
    }

    @DeleteMapping(path = "/dossiers/{id}")
    public void delete(@PathVariable Long id){
        manageDossierService.deleteDossier(id);
    }
}
