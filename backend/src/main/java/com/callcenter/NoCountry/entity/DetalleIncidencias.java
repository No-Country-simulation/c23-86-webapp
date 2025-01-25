package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Entidad que representa el detalle de una incidencia.
 * Cada detalle está asociado a una incidencia y registra la información
 * sobre modificaciones realizadas por empleados, incluyendo la descripción de dichas modificaciones.
 */
@Data
@Entity
@Table(name = "detalle_de_incidencias")
public class DetalleIncidencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Detalle")
    private Integer idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_Incidencia", nullable = false)
    private Incidencias incidencia;

    @ManyToOne
    @JoinColumn(name = "id_Empleado", nullable = false)
    private Empleados empleado;

    @Column(name = "fechaDeModificacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaDeModificacion;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "estado", nullable = false, length = 30) // Nuevo campo: estado
    private String estado;

    @Column(name = "prioridad", nullable = false) // Nuevo campo: prioridad
    private int prioridad;
}





