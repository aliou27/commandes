package com.polytech.commandes.service;

import com.polytech.commandes.entity.Commande;
import com.polytech.commandes.repository.CommandeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Transactional(readOnly = true)
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Commande findById(Long id) {
        return commandeRepository.findById(id);
    }

    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }

    public void delete(Long id) {
        commandeRepository.deleteById(id);
    }

    public void update(Commande commande) {
        commandeRepository.save(commande);
    }

}
