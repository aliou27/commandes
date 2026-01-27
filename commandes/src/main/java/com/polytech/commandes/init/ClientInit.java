package com.polytech.commandes.init;

import com.polytech.commandes.repository.ClientRepository;
import com.polytech.commandes.service.ClientService;
import org.springframework.boot.CommandLineRunner;

public class ClientInit implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final ClientService clientService;

    public ClientInit(ClientRepository clientRepository, ClientService clientService, ClientService clientService1) {
        this.clientService = clientService1;
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
