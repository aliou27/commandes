package com.polytech.commandes.config;

import com.polytech.commandes.entity.Client;
import com.polytech.commandes.entity.Commande;
import com.polytech.commandes.entity.Produit;
import com.polytech.commandes.repository.ClientRepository;
import com.polytech.commandes.repository.CommandeRepository;
import com.polytech.commandes.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final ProduitRepository produitRepository;
    private final CommandeRepository commandeRepository;

    @Override
    public void run(String... args) {

        log.info("=== Initialisation des données ===");

        Client client1 = new Client(null, "Aliou Diallo", "aliou.diallo@example.com");
        Client client2 = new Client(null, "Fatou Sow", "fatou.sow@example.com");
        Client client3 = new Client(null, "Moussa Kane", "moussa.kane@example.com");

        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);

        log.info("✓ 3 clients créés");

        Produit produit1 = new Produit(null, "Ordinateur Portable HP", new BigDecimal("450000"), 10);
        Produit produit2 = new Produit(null, "Souris Sans Fil Logitech", new BigDecimal("15000"), 50);
        Produit produit3 = new Produit(null, "Clavier Mécanique RGB", new BigDecimal("35000"), 25);
        Produit produit4 = new Produit(null, "Écran 24 pouces Dell", new BigDecimal("125000"), 15);
        Produit produit5 = new Produit(null, "Webcam HD", new BigDecimal("25000"), 30);

        produitRepository.save(produit1);
        produitRepository.save(produit2);
        produitRepository.save(produit3);
        produitRepository.save(produit4);
        produitRepository.save(produit5);

        log.info("✓ 5 produits créés");

        Commande commande1 = new Commande();
        commande1.setClient(client1);

        log.info("✓ 3 commandes créées");

        log.info("=== Initialisation terminée ===");


    }
}
