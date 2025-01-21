package com.callcenter.NoCountry.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Usuarios")
@Getter @Setter
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "ingresar nombre")
    private String nombre;
    @NotBlank(message = "ingresar apellido")
    private String apellido;
    @NotBlank(message = "ingresar correo")
    private String correo;
    @NotBlank(message = "ingresar telefono")
    private String telefono;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaBaja;
    
    protected Usuarios(String nombre, String apellido, String correo, String telefono, LocalDateTime fechaAlta, LocalDateTime fechaBaja){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }
}
