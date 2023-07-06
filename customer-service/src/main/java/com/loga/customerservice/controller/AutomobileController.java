package com.loga.customerservice.controller;

import com.loga.customerservice.entity.Automobile;
import com.loga.customerservice.service.IAutomobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-service")
public class AutomobileController {

    @Autowired
    private IAutomobileService manageAutomobile;

    @PostMapping(path = "/automobiles", produces = MediaType.APPLICATION_JSON_VALUE)
    public Automobile create(@RequestBody Automobile automobile){
        return manageAutomobile.createAutomobile(automobile);
    }

    @GetMapping(path = "/automobiles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Automobile> readAll(){
        return manageAutomobile.listAutomobile();
    }

    @GetMapping(path = "/automobiles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Automobile read(@PathVariable Long id){
        return manageAutomobile.findAutomobile(id);
    }

    @GetMapping(path = "/automobiles/number/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Automobile readByNumber(@PathVariable String number){
        return manageAutomobile.findAutomobile(number);
    }

    @GetMapping(path = "/automobiles/vin/{vin}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Automobile readByVin(@PathVariable String vin){
        return manageAutomobile.findAutomobile(vin);
    }

    @PutMapping(path = "/automobiles/{id}")
    public void edit(@RequestBody Automobile automobile, @PathVariable Long id){
        manageAutomobile.editAutomobile(automobile,id);
    }

    @DeleteMapping(path = "/automobiles/{id}")
    public void delete(@PathVariable Long id){
        manageAutomobile.deleteAutomobile(id);
    }
}
