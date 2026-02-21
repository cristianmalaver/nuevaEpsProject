package com.example.pruebanuevaeps.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {


    private Long id;
    private String username;
    private String nombre;
    private String email;
    private String rol;
}