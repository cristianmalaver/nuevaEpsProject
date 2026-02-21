package com.example.pruebanuevaeps.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class SolicitudDTO {

    private Long id;
    private String usuario;
    private String medicamento;
    private LocalDateTime fechaSolicitud;
}
