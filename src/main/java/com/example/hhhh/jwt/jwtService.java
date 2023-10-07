package com.example.hhhh.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Service
public class jwtService {



    private String secret = "TMZNBapW/tI95r6PkUVAnqf4/YWUnd4aofXFD9t6q6vTYQ5f4zCo5qNL44woZQYgY6EdtmgFqNKC+Lw6rubc0QZeH95t/5wPFhxjXI9kODmZumd5rP05ySN3dH6wl5vlNgLckOfp/5ciON7PTGkXEJHkOBWo/NVHDl36FXdIxd6uvfRSH7ZVOqTaVEe+MSQQH88cxyRWLxSmmqGsYucH16DQ9P2XmAitoqmCuP7w91CeFt3GX1aHNQF3otwVIqMOyIY0X2EKVr9yCAmucuNTiEnKm3YZj8tBHEvjNQsNUwChRovE+y6wzX+f1w3jIPXa+z0I3RIRhjG7DEQ25fnqECi7chVaKZ2P+IAKIWDQBzM=\n";

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }
    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*30))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }


    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
