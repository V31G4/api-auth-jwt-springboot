package com.article.api.service;

import com.article.api.dto.LoginDTO;
import com.article.api.entity.User;
import com.article.api.repository.UserRepository;
import com.article.api.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public String login(LoginDTO dto) {

        User user = repository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.senha(), user.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        return tokenService.gerarToken(user);
    }
}