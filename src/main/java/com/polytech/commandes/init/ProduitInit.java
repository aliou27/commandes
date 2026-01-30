package com.polytech.commandes.init;

import com.polytech.commandes.entity.Commande;
import com.polytech.commandes.repository.CommandeRepository;
import com.polytech.commandes.repository.ProduitRepository;
import com.polytech.commandes.service.ProduitService;
import org.springframework.boot.CommandLineRunner;

public class ProduitInit implements CommandLineRunner {

    private final ProduitRepository produitRepository;
    private final ProduitService produitService;

    public ProduitInit(ProduitRepository produitRepository, ProduitService produitService) {
        this.produitRepository = produitRepository;
        this.produitService = produitService;
    }


    @Override
    public void run(String... args) throws Exception {}

}
