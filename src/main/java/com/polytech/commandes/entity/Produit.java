package com.polytech.commandes.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ✅ Long, pas Integer

    @Column(nullable = false)
    private String nom;  // ✅ nom, pas name

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal prix;  // ✅ UN SEUL attribut prix

    @Column(nullable = false)
    private Integer stock;
}