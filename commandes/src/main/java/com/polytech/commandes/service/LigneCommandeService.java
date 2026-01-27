package com.polytech.commandes.service;

import com.polytech.commandes.entity.Commande;
import com.polytech.commandes.repository.ClientRepository;
import com.polytech.commandes.repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeService {

    private final CommandeRepository commandeRepository;

    public LigneCommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    public Commande findById(Long id) {
        return commandeRepository.findById(id);
    }

    public void save(Commande commande) {
        commandeRepository.save(commande);
    }

    public void delete(Commande commande) {
        commandeRepository.delete(commande);
    }

    public void update(Commande commande) {
        commandeRepository.save(commande);
    }

}
