package com.example.pruebanuevaeps.service.impl;

import com.example.pruebanuevaeps.dto.MedicamentoDTO;
import com.example.pruebanuevaeps.repository.MedicamentoRepository;
import com.example.pruebanuevaeps.service.MedicamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicamentoServiceImpl implements MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    @Override
    public List<MedicamentoDTO> listar() {
        return medicamentoRepository.findAll()
                .stream()
                .map(m -> MedicamentoDTO.builder()
                        .id(m.getId())
                        .nombre(m.getNombre())
                        .esPos(m.getEsPos())
                        .build())
                .toList();
    }
}
