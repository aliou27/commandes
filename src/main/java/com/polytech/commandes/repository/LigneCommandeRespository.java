package com.polytech.commandes.repository;

import com.polytech.commandes.entity.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeRespository extends JpaRepository<LigneCommande, Integer> {

    // Trouver toutes les lignes d'une commande
    List<LigneCommande> findByCommandeId(Long commandeId);

    // Trouver toutes les lignes contenant un produit spécifique
    List<LigneCommande> findByProduitId(Long produitId);

}
