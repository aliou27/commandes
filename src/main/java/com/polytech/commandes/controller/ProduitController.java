//package com.polytech.commandes.controller;
//
//import com.polytech.commandes.entity.Commande;
//import com.polytech.commandes.service.ProduitService;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController("/api/produit")
//public class ProduitController {
//
//    private ProduitService produitService;
//
//    public ProduitController(ProduitService produitService) {
//        this.produitService = produitService;
//    }
//
//    @GetMapping
//    public List<Commande> findAll() {
//        return produitService.findAll();
//    }
//
//    @PostMapping
//    public Commande save(@RequestBody Commande commande) {
//        return produitService.save(commande);
//    }
//
//    @DeleteMapping
//    public void delete(@RequestBody Commande commande) {
//        produitService.delete(commande);
//    }
//
//}
