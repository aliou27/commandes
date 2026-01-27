package com.polytech.commandes.service;

import com.polytech.commandes.entity.Commande;
import com.polytech.commandes.repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private CommandeRepository commandeRepository;
    public ProduitService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    public Commande save(Commande commande) {
        commandeRepository.save(commande);
        return commande;
    }

    public Commande findById(Long id) {
        return commandeRepository.findById(id);
    }

    public void update(Commande commande) {
        commandeRepository.save(commande);
    }

    public void delete(Commande commande) {
        commandeRepository.delete(commande);
    }



}
