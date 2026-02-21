package com.example.pruebanuevaeps.service;

import com.example.pruebanuevaeps.dto.UsuarioDTO;
import com.example.pruebanuevaeps.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    UsuarioDTO crear(Usuario usuario);

    List<UsuarioDTO> listar();
}