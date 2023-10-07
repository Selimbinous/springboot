package com.example.hhhh.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "produits")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "proid")
    private int proid;
    @Column(name = "nom")
    private String nom;
    @Column(name = "description")
    private String description;
    @Column(name = "quantite")
    private int quantite;
    @Column(name = "prix")
    private int prix;

    @ManyToMany(mappedBy = "products")
    private Set<Commande> commandes = new HashSet<>();
}
