package com.article.api.controller;

import com.article.api.dto.LoginDTO;
import com.article.api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {
        return service.login(dto);
    }
}