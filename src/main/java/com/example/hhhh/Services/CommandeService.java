package com.example.hhhh.Services;

import com.example.hhhh.Entities.Commande;
import com.example.hhhh.Entities.Product;
import com.example.hhhh.Exceptions.CommandeNotfoundException;
import com.example.hhhh.Repositories.CommandeRepo;
import com.example.hhhh.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepo commanderepo;
    @Autowired
    private emailSenderservice emailsender;
    public Commande addcommande(Commande com){
        List<Product> products = com.getProducts();
        products.forEach(product -> product.setQuantite(product.getQuantite()-1));
        if(products.size()>10){
            emailsender.sendEmail();
        }
        return commanderepo.save(com);

    }
    public List<Commande> getcommandes(){
        return commanderepo.findAll();

    }
    public Commande getcommande(int id){
        Optional<Commande> com = commanderepo.findById(id);
        if(!com.isPresent()){
            throw new CommandeNotfoundException("Commande not available...");
        }

        return com.get();
    }
    public Commande commandeupdate(int id,Commande com){
        com.setId(id);
        return commanderepo.save(com);
    }
    public void deletecommande(int id){
        commanderepo.deleteById(id);
    }
}
