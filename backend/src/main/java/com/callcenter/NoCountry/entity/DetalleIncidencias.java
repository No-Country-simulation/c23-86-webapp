package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

import lombok.AllArgsConstructor;

@Data
@Entity
@Table(name = "detalle_incidencias")
@AllArgsConstructor
public class DetalleIncidencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_incidencia", nullable = false)
    private Incidencias incidencia;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleados empleado;

    @Column(name = "fecha_de_modificacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaDeModificacion;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;
    
    public DetalleIncidencias(){
        
    }
}




