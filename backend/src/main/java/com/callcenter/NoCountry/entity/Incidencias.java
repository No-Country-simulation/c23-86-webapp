package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad que representa una incidencia, AKA: reclamo, en el sistema.
 * Las incidencias registran problemas o situaciones reportadas por clientes
 * relacionadas con un servicio específico.
 */
@Entity
@Table(name = "incidencias")
@Data
public class Incidencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidencia")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_de_alta", nullable = false)
    private LocalDateTime fechaDeAlta;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_Cliente", nullable = false)
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "id_Servicio", nullable = false)
    private Servicios servicio;

    @OneToMany(mappedBy = "incidencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleIncidencias> detalles;
}
