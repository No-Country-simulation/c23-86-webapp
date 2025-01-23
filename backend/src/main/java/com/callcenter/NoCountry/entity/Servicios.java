package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "servicios")
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Servicio")
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    
    @OneToMany
    private List<ClienteServicio> clienteServicios;

}
