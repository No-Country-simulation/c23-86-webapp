package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "rol", nullable = false)
    private String rol;

    @Column(name = "correo_personal", nullable = false, unique = true)
    private String correoPersonal;

    @Column(name = "correo_empresarial", nullable = false, unique = true)
    private String correoEmpresarial;

    @Column(name = "clave", nullable = false)
    private String clave;

    @Column(name = "telefono", nullable = false, unique = true)
    private String telefono;

    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @Column(name = "activo", nullable = false)
    private boolean activo;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<DetalleIncidencias> detalles;

}