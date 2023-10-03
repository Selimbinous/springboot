package com.example.hhhh.Services;

import com.example.hhhh.Entities.Product;
import com.example.hhhh.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productrepo;
    public Product addproduct(Product prod){

        return productrepo.save(prod);

    }
    public List<Product> getproducts(){
        return productrepo.findAll();

    }
    public Product getproduct(int id){
        Optional<Product> product = productrepo.findById(id);

        return product.get();
    }
    public Product productupdate(int id,Product prod){
        prod.setId(id);
        return productrepo.save(prod);
    }
    public void deleteproduct(int id){
        productrepo.deleteById(id);
    }
}
