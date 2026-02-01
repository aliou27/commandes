package com.polytech.commandes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data


public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateCommande;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LigneCommande> lignes = new ArrayList<>();
        public Commande(LocalDate localDate, BigDecimal bigDecimal, Client client3) {
    }

    public boolean isPresent() {
        return !lignes.isEmpty();
    }

    @Enumerated(EnumType.STRING)
    private StatusCommande status;

    public void setStatus(StatusCommande statusCommande) {

    }
}
