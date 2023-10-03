package com.example.hhhh.Controller;

import com.example.hhhh.Entities.Client;
import com.example.hhhh.Entities.Product;
import com.example.hhhh.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;
    @PostMapping("/product")
    public Product addproduct(@RequestBody Product prod){
        return service.addproduct(prod);

    }
    @GetMapping("/product")
    public List<Product> getproducts(){
        return service.getproducts();
    }

    @GetMapping(value = "/product/{id}")
    public Product getproduct(@PathVariable("id") int id){
        return service.getproduct(id);
    }

    @PutMapping(value = "/product/{id}")
    public Product updateproduct(@RequestBody Product prod,@PathVariable("id") int id){
        return service.productupdate(id,prod);
    }

    @DeleteMapping(value = "/product/{id}")
    public void deleteproduct(@PathVariable("id") int id ){
        service.deleteproduct(id);
    }

}
