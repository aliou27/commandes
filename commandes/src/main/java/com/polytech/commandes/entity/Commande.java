package com.polytech.commandes.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity


public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateCommande;

    /* @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20);
     private CommandeStatus status; */

   // private Client client;
    List <LigneCommande > lignes;

}
