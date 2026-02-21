package com.example.pruebanuevaeps.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SolicitudRequest {

    @NotNull(message = "medicamentoId es obligatorio")
    private Long medicamentoId;

    private String numeroOrden;
    private String direccion;
    private String telefono;
    private String correo;
}
