package com.article.api.dto;

import com.article.api.entity.Role;

public record UserResponseDTO(
        Long id,
        String nome,
        String email,
        Role role
) {}
