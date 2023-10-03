package com.example.hhhh.Repositories;

import com.example.hhhh.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Override
    List<Product> findAll();
}
