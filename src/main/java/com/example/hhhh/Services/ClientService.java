package com.example.hhhh.Services;

import com.example.hhhh.Entities.Client;
import com.example.hhhh.Exceptions.CommandeNotfoundException;
import com.example.hhhh.Repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepo clientrepo;
    public Client addclient(Client client){

        return clientrepo.save(client);

    }
    public List<Client> getclients(){
        return clientrepo.findAll();

    }
    public Client getclient(int id){
        Optional<Client> client = clientrepo.findById(id);
        return client.get();
    }
    public Client clientupdate(int id,Client client){
        client.setId(id);
        return clientrepo.save(client);
    }
    public void deleteclient(int id){
        clientrepo.deleteById(id);
    }
}
