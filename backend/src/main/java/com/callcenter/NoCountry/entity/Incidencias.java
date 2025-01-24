package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Data;

import java.util.List;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "incidencias")
@Data
@AllArgsConstructor
public class Incidencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "ingrese prioridad")
    private int prioridad;
    @NotBlank(message = "ingrese estado")
    private String estado;
    @NotBlank(message = "ingrese fecha de alta")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_de_alta")
    private LocalDateTime fechaDeAlta;
    @NotBlank(message = "ingrese descripcion")
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