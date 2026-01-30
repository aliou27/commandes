package com.polytech.commandes.repository;

import com.polytech.commandes.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findByPrixLessThanEqual(BigDecimal prix);

    // Méthode de recherche 2 : Trouver les produits avec stock suffisant
    List<Produit> findByStockGreaterThanEqual(Integer stock);

}
