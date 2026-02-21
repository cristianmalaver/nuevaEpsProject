package com.example.pruebanuevaeps.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "solicitudes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;

    @Column(name = "numero_orden")
    private String numeroOrden;

    private String direccion;

    private String telefono;

    private String correo;

    @Column(name = "fecha_solicitud")
    private LocalDateTime fechaSolicitud;
}
