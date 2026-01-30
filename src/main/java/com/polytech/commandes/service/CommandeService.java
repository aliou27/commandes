package com.polytech.commandes.service;

import com.polytech.commandes.entity.Commande;
import com.polytech.commandes.repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    public Commande findById(Long id) {
        return commandeRepository.findById(id);
    }

    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }

    public void delete(Commande commande) {
        commandeRepository.delete(commande);
    }

}
