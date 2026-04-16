package com.article.api.controller;

import com.article.api.dto.CreateUserDTO;
import com.article.api.dto.UserResponseDTO;
import com.article.api.entity.User;
import com.article.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public User criar(@RequestBody @jakarta.validation.Valid CreateUserDTO dto) {
        return service.criarUsuario(dto);
    }

    @GetMapping
    public java.util.List<UserResponseDTO> listar() {
        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    public User buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
