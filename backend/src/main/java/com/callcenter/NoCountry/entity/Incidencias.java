package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "incidencias")
@Data
public class Incidencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidencia")
    private Long id;
    private int prioridad;
    private String estado;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_de_alta")
    private LocalDateTime fechaDeAlta;
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