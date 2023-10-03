package com.example.hhhh.Repositories;


import com.example.hhhh.Entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommandeRepo extends JpaRepository<Commande,Integer> {
    @Override
    List<Commande> findAll();
}
