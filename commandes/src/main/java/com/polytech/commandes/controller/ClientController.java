package com.polytech.commandes.controller;

import com.polytech.commandes.entity.Client;
import com.polytech.commandes.repository.ClientRepository;
import com.polytech.commandes.service.ClientService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController("/api/clients")
public class ClientController {

    public final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("{/id}")
    public Client findById(@PathVariable String id) {
        return clientService.findById(Long.valueOf(id));
    }


    @PostMapping
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@RequestBody Client client) {
        clientService.delete((Client) id);
    }

}
