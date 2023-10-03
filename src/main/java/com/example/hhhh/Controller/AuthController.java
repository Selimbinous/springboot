package com.example.hhhh.Controller;

import com.example.hhhh.Entities.Client;
import com.example.hhhh.Exceptions.CommandeNotfoundException;
import com.example.hhhh.Repositories.ClientRepo;
import com.example.hhhh.Services.ClientService;
import com.example.hhhh.dto.loginreq;
import com.example.hhhh.dto.registerreq;
import com.example.hhhh.jwt.jwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private ClientService service;
    @Autowired
     private jwtService jwtservice;

    private AuthenticationManager authenticationManager;
    @PostMapping("/welcome")
    public String home(){
        return "Welcome";
    }

    @PostMapping("/login")
    public String login(@RequestBody loginreq request){
        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNom(),request.getMdp()));
        if(authentication.isAuthenticated()){
        return jwtservice.generateToken(request.getNom());
    }else {
            throw new CommandeNotfoundException("invalid request");
        }
    }
    @PostMapping("/register")
    public String register(@RequestBody registerreq request){
        Client client = new Client(request.getNom(), request.getPrenom(),
                request.getEmail(),request.getMdp(), request.getRole());
        service.addclient(client);
        return "user registred successfully!!";
    }
}
