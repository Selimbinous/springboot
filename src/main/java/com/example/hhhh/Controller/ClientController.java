package com.example.hhhh.Controller;

import com.example.hhhh.Entities.Client;
import com.example.hhhh.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientService service;
    @PostMapping("/client")
    public Client addclient(@RequestBody Client client){
        return service.addclient(client);

    }
    @GetMapping("/client")
    public List<Client> getclients(){
        return service.getclients();
    }

    @GetMapping(value = "/client/{id}")
    public Client getuser(@PathVariable("id") int id){
        return service.getclient(id);
    }

    @PutMapping(value = "/client/{id}")
    public Client updateUser(@RequestBody Client client,@PathVariable("id") int id){
        return service.clientupdate(id,client);
    }

    @DeleteMapping(value = "/client/{id}")
    public void deleteclient(@PathVariable("id") int id ){
        service.deleteclient(id);
    }

}
