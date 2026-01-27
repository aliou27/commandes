package com.polytech.commandes.service;

import com.polytech.commandes.entity.Client;
import com.polytech.commandes.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id);
    }
    public Client save(Client client) {
        return clientRepository.save(client);
    }
    public void delete(Client client) {
        clientRepository.delete(client);
    }
    public List<Client> findByNom(String nom) {
        return Collections.singletonList(clientRepository.findByNom(nom));
    }

    public void update(Client client) {
        clientRepository.save(client);
    }

}


