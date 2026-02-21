package com.example.pruebanuevaeps.controller;

import com.example.pruebanuevaeps.dto.SolicitudDTO;
import com.example.pruebanuevaeps.dto.SolicitudRequest;
import com.example.pruebanuevaeps.service.SolicitudService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@RequiredArgsConstructor
@CrossOrigin
public class SolicitudController {

    private final SolicitudService solicitudService;

    @PostMapping
    public SolicitudDTO crear(@Valid @RequestBody SolicitudRequest request) {
        return solicitudService.crear(request);
    }

    @GetMapping
    public Page<SolicitudDTO> listar(Pageable pageable) {
        return solicitudService.listar(pageable);
    }
}
