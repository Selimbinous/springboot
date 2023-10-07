package com.example.hhhh.Services;

import com.example.hhhh.Entities.Client;
import com.example.hhhh.Repositories.ClientRepo;
import com.example.hhhh.dto.loginreq;
import com.example.hhhh.dto.registerreq;
import com.example.hhhh.jwt.jwtService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class AuthService {
    @Autowired
    private ClientRepo repository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    jwtService jwtTokenUtils;
    @Autowired
     AuthenticationManager authenticationManager;

    public String login(loginreq loginRequest)
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getNom(), loginRequest.getMdp()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return this.jwtTokenUtils.generateToken(userDetails);
    }

    public String register(registerreq registerRequest) {
        Client user = new Client();
        user.setNom(registerRequest.getNom());
        user.setPrenom(registerRequest.getPrenom());
        user.setEmail(registerRequest.getEmail());
        user.setMdp(passwordEncoder.encode(registerRequest.getMdp()));
        user.setRole(registerRequest.getRole());

        repository.save(user);
        return "User registered successfully!";
    }
}
