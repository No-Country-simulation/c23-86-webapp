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

//    // Constructor a partir de un incidenciaDTO
//    public Incidencias(IncidenciaDTO incidenciaDTO) {
//        if (incidenciaDTO.getCliente() == null || incidenciaDTO.getCliente().getId() == null) {
//            throw new IllegalArgumentException("El cliente es obligatorio y debe tener un ID válido.");
//        }
//
//        if (incidenciaDTO.getServicio() == null || incidenciaDTO.getServicio().getId() == null) {
//            throw new IllegalArgumentException("El servicio es obligatorio y debe tener un ID válido.");
//        }
//
//        this.prioridad = incidenciaDTO.getPrioridad();
//        this.estado = incidenciaDTO.getEstado();
//        this.descripcion = incidenciaDTO.getDescripcion();
//        this.fechaDeAlta = incidenciaDTO.getFechaDeAlta();
//
//        // Asignar cliente
//        Clientes cliente = new Clientes();
//        cliente.setId(incidenciaDTO.getCliente().getId());
//        this.cliente = cliente;
//
//        // Asignar servicio
//        Servicios servicio = new Servicios();
//        servicio.setId(incidenciaDTO.getServicio().getId());
//        this.servicio = servicio;
//    }
}