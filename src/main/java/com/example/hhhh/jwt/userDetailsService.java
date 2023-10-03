package com.example.hhhh.jwt;

import com.example.hhhh.Entities.Client;
import com.example.hhhh.Exceptions.CommandeNotfoundException;
import com.example.hhhh.Repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userDetailsService implements UserDetailsService {
    @Autowired
    private ClientRepo clientRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> client = clientRepo.findByNom(username);
        if (client.isEmpty()) {
            throw new CommandeNotfoundException("Client = " + username + " not found");
        }
        return new org.springframework.security.core.userdetails.User(client.get().getUsername(),client.get().getPassword(),client.get().getAuthorities());
    }
}
