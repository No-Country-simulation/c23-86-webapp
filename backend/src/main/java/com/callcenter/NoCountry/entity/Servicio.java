package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Servicio;
    private String nombre;
    private String descripcion;
    private double precio;
}
