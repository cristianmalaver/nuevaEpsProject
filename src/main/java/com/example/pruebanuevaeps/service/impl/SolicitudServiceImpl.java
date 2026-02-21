package com.example.pruebanuevaeps.service.impl;

import com.example.pruebanuevaeps.dto.SolicitudDTO;
import com.example.pruebanuevaeps.dto.SolicitudRequest;
import com.example.pruebanuevaeps.entity.Medicamento;
import com.example.pruebanuevaeps.entity.Solicitud;
import com.example.pruebanuevaeps.entity.Usuario;
import com.example.pruebanuevaeps.repository.MedicamentoRepository;
import com.example.pruebanuevaeps.repository.SolicitudRepository;
import com.example.pruebanuevaeps.repository.UsuarioRepository;
import com.example.pruebanuevaeps.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;


@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final UsuarioRepository usuarioRepository;
    private final MedicamentoRepository medicamentoRepository;


    @Override
    public SolicitudDTO crear(SolicitudRequest request) {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Medicamento medicamento = medicamentoRepository.findById(request.getMedicamentoId())
                .orElseThrow(() -> new IllegalArgumentException("Medicamento no encontrado"));

        if (!medicamento.getEsPos()) {

            if (request.getNumeroOrden() == null ||
                    request.getDireccion() == null ||
                    request.getTelefono() == null ||
                    request.getCorreo() == null) {

                throw new IllegalArgumentException("Para medicamentos NO POS todos los campos adicionales son obligatorios");
            }
        }

        Solicitud solicitud = Solicitud.builder()
                .usuario(usuario)
                .medicamento(medicamento)
                .numeroOrden(request.getNumeroOrden())
                .direccion(request.getDireccion())
                .telefono(request.getTelefono())
                .correo(request.getCorreo())
                .fechaSolicitud(java.time.LocalDateTime.now())
                .build();

        Solicitud guardada = solicitudRepository.save(solicitud);

        return SolicitudDTO.builder()
                .id(guardada.getId())
                .usuario(usuario.getUsername())
                .medicamento(medicamento.getNombre())
                .fechaSolicitud(guardada.getFechaSolicitud())
                .build();
    }

    @Override
    public Page<SolicitudDTO> listar(Pageable pageable) {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return solicitudRepository
                .findByUsuarioUsername(username, pageable)
                .map(s -> SolicitudDTO.builder()
                        .id(s.getId())
                        .usuario(s.getUsuario().getUsername())
                        .medicamento(s.getMedicamento().getNombre())
                        .fechaSolicitud(s.getFechaSolicitud())
                        .build());
    }

}
