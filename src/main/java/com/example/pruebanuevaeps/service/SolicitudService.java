package com.example.pruebanuevaeps.service;

import com.example.pruebanuevaeps.dto.SolicitudDTO;
import com.example.pruebanuevaeps.dto.SolicitudRequest;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SolicitudService {

    SolicitudDTO crear(SolicitudRequest request);

    Page<SolicitudDTO> listar(Pageable pageable);
}
