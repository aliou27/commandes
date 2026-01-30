package com.polytech.commandes.repository;

import com.polytech.commandes.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository  extends JpaRepository<Client, Integer> {

    Client findById(Long id);

    Client findByName(String name);

}
