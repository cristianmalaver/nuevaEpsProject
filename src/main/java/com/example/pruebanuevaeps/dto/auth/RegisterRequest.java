package com.example.pruebanuevaeps.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Username es obligatorio")
    private String username;

    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email es obligatorio")
    private String email;

    @Size(min = 6, message = "Password mínimo 6 caracteres")
    private String password;

    @NotBlank(message = "Rol es obligatorio")
    private String rol;
}
