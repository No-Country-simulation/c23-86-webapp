package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "clientes")
@Data
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dni", unique = true, nullable = false)
    private Long dni;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "telefono", nullable = false, unique = true)
    private String telefono;

    @Column(name = "estado", nullable = false)
    private String estado;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<ClienteServicio> servicios;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Incidencias> incidencias;
}