package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Data;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que representa una incidencia, AKA: reclamo, en el sistema.
 * Las incidencias registran problemas o situaciones reportadas por clientes
 * relacionadas con un servicio específico.
 */
@Entity
@Table(name = "incidencias")
@AllArgsConstructor
@Getter @Setter
public class Incidencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotBlank(message = "ingrese prioridad")
    private int prioridad;
    
    @NotBlank(message = "ingrese estado")
    private String estado;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_de_alta", nullable = false)
    private LocalDateTime fechaDeAlta;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false)
    private Servicios servicio;

    @OneToMany(mappedBy = "incidencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleIncidencias> detalles;
    
    public Incidencias(){
        
    }
}

