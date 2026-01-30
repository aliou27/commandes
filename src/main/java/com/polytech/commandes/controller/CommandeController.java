//package com.polytech.commandes.controller;
//
//import com.polytech.commandes.entity.Commande;
//import com.polytech.commandes.repository.CommandeRepository;
//import com.polytech.commandes.service.CommandeService;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController("/api/commandes")
//public class CommandeController {
//
//    final CommandeService commandeService;
//    @Autowired
//    public CommandeController(CommandeService commandeService) {
//        this.commandeService = commandeService;
//    }
//
//    @GetMapping
//    public List<Commande> findAll() {
//        return commandeService.findAll();
//    }
//
//    @PostMapping
//    public Commande save(@RequestBody Commande commande) {
//        return commandeService.save(commande);
//    }
//
//    @DeleteMapping
//    public void delete(@RequestBody Commande commande) {
//        commandeService.delete(commande);
//    }
//
//    @PutMapping
//    public Commande update(@RequestBody Commande commande) {
//        return commandeService.save(commande);
//    }
//
//}
