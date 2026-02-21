package com.example.pruebanuevaeps.service.impl;

import com.example.pruebanuevaeps.dto.UsuarioDTO;
import com.example.pruebanuevaeps.entity.Usuario;
import com.example.pruebanuevaeps.repository.UsuarioRepository;
import com.example.pruebanuevaeps.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO crear(Usuario usuario) {
        Usuario guardado = usuarioRepository.save(usuario);
        return mapToDTO(guardado);
    }

    @Override
    public List<UsuarioDTO> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private UsuarioDTO mapToDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .username(usuario.getUsername())
                .nombre(usuario.getNombre())
                .email(usuario.getEmail())
                .rol(usuario.getRol())
                .build();
    }
}