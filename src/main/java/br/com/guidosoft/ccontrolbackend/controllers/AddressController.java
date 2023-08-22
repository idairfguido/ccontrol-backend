package br.com.guidosoft.ccontrolbackend.controllers;

import br.com.guidosoft.ccontrolbackend.entities.Address;
import br.com.guidosoft.ccontrolbackend.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Address> getAll(){
        return repository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void insert(@RequestBody Address data){
        repository.save(data);
        return;
    }

}
