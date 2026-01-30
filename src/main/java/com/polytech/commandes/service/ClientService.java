package com.polytech.commandes.service;

import com.polytech.commandes.entity.Client;
import com.polytech.commandes.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {

        this.clientRepository = clientRepository;

    }

    @Transactional(readOnly = true)
    public List<Client> findAll() {

        return clientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional <Client> findById(Long id) {

        return Optional.ofNullable(clientRepository.findById(id));
    }

    public Client save(Client client) {

        return clientRepository.save(client);
    }

    public void delete(Client client) {

        clientRepository.delete(client);
    }

    public List<Client> findByNom(String nom)
    {
        String name = "";
        return Collections.singletonList(clientRepository.findByName(name));
    }

    public void update(Client client) {

        clientRepository.save(client);
    }

}


