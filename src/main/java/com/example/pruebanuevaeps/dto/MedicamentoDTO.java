package com.example.pruebanuevaeps.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MedicamentoDTO {

    private Long id;
    private String nombre;
    private Boolean esPos;
}
