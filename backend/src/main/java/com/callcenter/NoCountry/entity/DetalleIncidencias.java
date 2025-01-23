package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

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
    private Date fechaDeModificacion;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;
}




