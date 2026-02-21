package com.example.pruebanuevaeps.controller;

import com.example.pruebanuevaeps.dto.MedicamentoDTO;
import com.example.pruebanuevaeps.service.MedicamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
@RequiredArgsConstructor
@CrossOrigin
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    @GetMapping
    public List<MedicamentoDTO> listar() {
        return medicamentoService.listar();
    }
}
