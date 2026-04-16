package com.article.api.service;

import com.article.api.dto.CreateUserDTO;
import com.article.api.dto.UserResponseDTO;
import com.article.api.entity.User;
import com.article.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public User criarUsuario(CreateUserDTO dto) {

        User user = User.builder()
                .nome(dto.nome())
                .email(dto.email())
                .senha(passwordEncoder.encode(dto.senha()))
                .role(dto.role())
                .build();

        return repository.save(user);
    }

    public User buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public java.util.List<UserResponseDTO> listarUsuarios() {
        return repository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getNome(),
                        user.getEmail(),
                        user.getRole()
                ))
                .toList();
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
