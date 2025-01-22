package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Servicios")
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Servicio;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    
    @OneToMany(mappedBy = "id_Servicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClienteServicio> clienteServicios;

}
