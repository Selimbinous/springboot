package com.example.hhhh.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class registerreq {

    String nom;
    String prenom;
    String email;
    String mdp;
    String role;
}
