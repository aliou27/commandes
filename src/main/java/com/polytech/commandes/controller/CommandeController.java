package com.polytech.commandes.controller;

import com.polytech.commandes.entity.Commande;
import com.polytech.commandes.service.CommandeService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    final CommandeService commandeService;
    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping
    public ResponseEntity<List<Commande>> findAll() {
        List<Commande> commandes = commandeService.findAll();
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> findById(@PathVariable Long id) {
        if(commandeService.findById(id).isPresent()) {
            return new ResponseEntity<>(commandeService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Commande> save(@RequestBody Commande commande) {
        Commande commande1 = commandeService.save(commande);
        return new ResponseEntity<>(commande1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        commandeService.delete(Long.valueOf(id));
        return  noContent().build();
    }

}
