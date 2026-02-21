package com.example.pruebanuevaeps.service.auth.impl;

import com.example.pruebanuevaeps.dto.auth.LoginRequest;
import com.example.pruebanuevaeps.dto.auth.RegisterRequest;
import com.example.pruebanuevaeps.entity.Usuario;
import com.example.pruebanuevaeps.repository.UsuarioRepository;
import com.example.pruebanuevaeps.security.JwtService;
import com.example.pruebanuevaeps.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public void register(RegisterRequest request) {

        if (usuarioRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("El username ya existe");
        }

        Usuario usuario = Usuario.builder()
                .username(request.getUsername())
                .nombre(request.getNombre())
                .email(request.getEmail())
                .rol(request.getRol())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        usuarioRepository.save(usuario);
    }

    @Override
    public String login(LoginRequest request) {

        Usuario usuario = usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new IllegalArgumentException("Credenciales inválidas");
        }

        return jwtService.generateToken(usuario.getUsername());
    }

}
