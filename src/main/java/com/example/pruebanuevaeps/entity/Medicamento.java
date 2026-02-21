package com.example.pruebanuevaeps.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "es_pos", nullable = false)
    private Boolean esPos;
}
