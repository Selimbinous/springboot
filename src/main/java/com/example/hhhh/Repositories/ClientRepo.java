package com.example.hhhh.Repositories;

import com.example.hhhh.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client,Integer> {
    Optional<Client> findByNom(String nom);

    @Override
    List<Client> findAll();




}
