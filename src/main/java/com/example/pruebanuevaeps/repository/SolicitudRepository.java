package com.example.pruebanuevaeps.repository;

import com.example.pruebanuevaeps.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    Page<Solicitud> findByUsuarioUsername(String username, Pageable pageable);
}
