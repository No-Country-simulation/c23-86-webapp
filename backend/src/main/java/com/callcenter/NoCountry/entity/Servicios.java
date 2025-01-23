package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "servicios")
@Data
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Servicio")
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
}
