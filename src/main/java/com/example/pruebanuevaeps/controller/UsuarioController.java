package com.example.pruebanuevaeps.controller;

import com.example.pruebanuevaeps.dto.UsuarioDTO;
import com.example.pruebanuevaeps.entity.Usuario;
import com.example.pruebanuevaeps.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public UsuarioDTO crear(@RequestBody Usuario usuario) {
        return usuarioService.crear(usuario);
    }

    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioService.listar();
    }
}