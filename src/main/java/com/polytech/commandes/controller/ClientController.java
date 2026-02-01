package com.polytech.commandes.controller;

import com.polytech.commandes.entity.Client;
import com.polytech.commandes.service.ClientService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    public final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients = clientService.findAll();
        return ok().body(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
       if(clientService.findById(id).isPresent()) {
           return  ok().body(clientService.findById(id).get());
       }
       return notFound().build();
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client newClient = clientService.save(client);
        return status(HttpStatus.CREATED).body(newClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@RequestBody Client client) {
        clientService.delete(client);
        return noContent().build();
    }

}
