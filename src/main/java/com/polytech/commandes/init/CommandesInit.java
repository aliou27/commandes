package com.polytech.commandes.init;

import com.polytech.commandes.repository.CommandeRepository;
import com.polytech.commandes.service.CommandeService;
import org.springframework.boot.CommandLineRunner;


public class CommandesInit implements CommandLineRunner {

    private CommandeRepository commandeRepository;
    private CommandeService commandeService;
    public CommandesInit(CommandeRepository commandeRepository, CommandeService commandeService) {
        this.commandeRepository = commandeRepository;
        this.commandeService = commandeService;
    }


    @Override
    public void run(String... args) throws Exception {}

}
