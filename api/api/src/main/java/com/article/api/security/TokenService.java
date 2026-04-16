package com.article.api.security;

import com.article.api.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private static final String SECRET = "minha-chave-secreta";

    public String gerarToken(User user) {
        return JWT.create()
                .withIssuer("api")
                .withSubject(user.getEmail())
                .withExpiresAt(dataExpiracao())
                .sign(Algorithm.HMAC256(SECRET));
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }

    public String validarToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(SECRET))
                    .withIssuer("api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (Exception e) {
            return null;
        }
    }
}