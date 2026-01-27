package com.polytech.commandes.repository;

import com.polytech.commandes.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {


    Commande findById(Long id);
}
