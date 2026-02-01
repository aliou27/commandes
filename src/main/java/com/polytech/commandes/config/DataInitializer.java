package com.polytech.commandes.config;

import com.polytech.commandes.entity.*;
import com.polytech.commandes.repository.ClientRepository;
import com.polytech.commandes.repository.CommandeRepository;
import com.polytech.commandes.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile("dev")
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

        // ========================================
        // 3. CRÉER DES COMMANDES AVEC LIGNES
        // ========================================
        log.info("🛒 Création des commandes avec lignes...");

        // --- COMMANDE 1 : Aliou (CREATED) ---
        Commande commande1 = new Commande();
        commande1.setClient(client1);
        commande1.setDateCommande(LocalDateTime.now().minusDays(2));
        commande1.setStatus(StatusCommande.CREATED);

        // Ligne 1 : 2 ordinateurs
        LigneCommande ligne1_1 = new LigneCommande();
        ligne1_1.setCommande(commande1);
        ligne1_1.setProduit(produit1);
        ligne1_1.setQuantite(2);
        ligne1_1.setPrixUnitaire(produit1.getPrix());

        // Ligne 2 : 3 souris
        LigneCommande ligne1_2 = new LigneCommande();
        ligne1_2.setCommande(commande1);
        ligne1_2.setProduit(produit2);
        ligne1_2.setQuantite(3);
        ligne1_2.setPrixUnitaire(produit2.getPrix());

        commande1.setLignes(Arrays.asList(ligne1_1, ligne1_2));
        commandeRepository.save(commande1);

        BigDecimal total1 = calculateTotal(commande1);

        log.info("=== Initialisation terminée ===");


    }

    private BigDecimal calculateTotal(Commande commande) {
        return commande.getLignes().stream()
                .map(ligne ->
                        ligne.getPrixUnitaire()
                                .multiply(BigDecimal.valueOf(ligne.getQuantite()))
                )
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
