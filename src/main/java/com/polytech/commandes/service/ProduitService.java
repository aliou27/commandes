package com.polytech.commandes.service;

import com.polytech.commandes.entity.Produit;
import com.polytech.commandes.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProduitService {

    private final ProduitRepository produitRepository;

    @Transactional(readOnly = true)
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Produit> findById(Long id) {
        return produitRepository.findById(id);
    }

    public Produit create(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit update(Long id, Produit produitDetails) {
        Optional<Produit> produitOpt = produitRepository.findById(id);
        if (produitOpt.isPresent()) {
            Produit produit = produitOpt.get();
            produit.setNom(produitDetails.getNom());
            produit.setPrix(produitDetails.getPrix());
            produit.setStock(produitDetails.getStock());
            return produitRepository.save(produit);
        }
        return null;
    }

    public void delete(Long id) {
        produitRepository.deleteById(id);
    }
}