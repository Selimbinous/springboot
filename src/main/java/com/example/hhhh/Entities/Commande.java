package com.example.hhhh.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "commandes")
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comid")
    private int comid;
    @Column(name = "prixtotal")
    private int prix_total;
    @ManyToMany
    @JoinTable(name = "Commande_Products",joinColumns = @JoinColumn(name = "commande_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    @ManyToOne
    private Client client;

}
