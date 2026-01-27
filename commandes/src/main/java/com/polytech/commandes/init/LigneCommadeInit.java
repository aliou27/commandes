package com.polytech.commandes.init;

import com.polytech.commandes.service.LigneCommandeService;
import org.springframework.boot.CommandLineRunner;

public class LigneCommadeInit implements CommandLineRunner {

    private final LigneCommadeInit ligneCommadeInit;
    private final LigneCommandeService ligneCommandeService;

    public LigneCommadeInit(LigneCommadeInit ligneCommadeInit, LigneCommandeService ligneCommandeService) {
        this.ligneCommadeInit = ligneCommadeInit;
        this.ligneCommandeService = ligneCommandeService;
    }


    @Override
    public void run(String... args) throws Exception {}
}
