package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "servicios")
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    
    @OneToMany(mappedBy = "idServicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClienteServicio> clienteServicios;
    
    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Incidencias> incidencias;
    
    public Servicios(){   
    }
    
    public Servicios(String nombre, String descripcion, BigDecimal precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}
