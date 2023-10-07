package com.example.hhhh.Controller;

import com.example.hhhh.Entities.Client;
import com.example.hhhh.Exceptions.CommandeNotfoundException;
import com.example.hhhh.Repositories.ClientRepo;
import com.example.hhhh.Services.AuthService;
import com.example.hhhh.Services.ClientService;
import com.example.hhhh.dto.LoginResponse;
import com.example.hhhh.dto.loginreq;
import com.example.hhhh.dto.mesresponse;
import com.example.hhhh.dto.registerreq;
import com.example.hhhh.jwt.jwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody loginreq loginRequest)
    {
        String token = this.authService.login(loginRequest);
        return ResponseEntity.ok(new LoginResponse(token,"Bearer", "Login successfully"));
    }

    @PostMapping("/register")
    public ResponseEntity<mesresponse> signin(@RequestBody registerreq registerRequest) {
        String message = this.authService.register(registerRequest);
        return ResponseEntity.ok(new mesresponse(message));
    }

}
