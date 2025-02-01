package com.callcenter.NoCountry.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Ingresar dni")
    @Column(name = "dni", nullable = false, unique = true)
    private Long dni;

    @NotBlank(message = "ingresar nombre")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotBlank(message = "ingresar apellido")
    @Column(name ="apellido", nullable = false)
    private String apellido;

    @NotBlank(message = "ingresar correo")
    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @NotBlank(message = "ingresar telefono")
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "activo")
    private boolean activo = true;

    protected Usuarios(Long dni, String nombre, String apellido, String correo, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }
}
