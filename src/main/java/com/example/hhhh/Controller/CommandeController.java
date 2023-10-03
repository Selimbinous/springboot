package com.example.hhhh.Controller;

import com.example.hhhh.Entities.Commande;

import com.example.hhhh.Services.CommandeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommandeController {
    @Autowired
    CommandeService service;
    @PostMapping("/passercommande")
    public Commande addcommande(@RequestBody Commande com){
        return service.addcommande(com);

    }
    @GetMapping("/commande")
    public List<Commande> getcommandes(){
        return service.getcommandes();
    }

    @GetMapping(value = "/commande/{id}")
    public Commande getcommande(@PathVariable("id") int id){
        return service.getcommande(id);
    }

    @PutMapping(value = "/commande/{id}")
    public Commande updatecommande(@RequestBody Commande com, @PathVariable("id") int id){
        return service.commandeupdate(id,com);
    }

    @DeleteMapping(value = "/commande/{id}")
    public void deletecommande(@PathVariable("id") int id ){
        service.deletecommande(id);
    }




}
