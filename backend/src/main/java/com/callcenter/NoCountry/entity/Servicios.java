package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "servicios")
@Getter @Setter
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    
    @Column(name = "precio", nullable = false)
    private BigDecimal precio;
    
    //@OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    //private List<ClienteServicio> clientes;
    
    //@OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    //private List<Incidencias> incidencias;
    
    public Servicios(){   
    }
    
    public Servicios(String nombre, String descripcion, BigDecimal precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}
