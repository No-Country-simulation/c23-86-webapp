package com.callcenter.NoCountry.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank(message = "Ingresar dni")
    @Column(name = "dni")
    private Long dni;
    
    @NotBlank(message = "ingresar nombre")
    @Column(name = "nombre")
    private String nombre;
    
    @NotBlank(message = "ingresar apellido")
    @Column(name ="apellido")
    private String apellido;
    
    @NotBlank(message = "ingresar correo")
    @Column(name = "correo")
    private String correo;
    
    @NotBlank(message = "ingresar telefono")
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "activo")
    private boolean activo = true;
    
    protected Usuarios(Long dni, String nombre, String apellido, String correo, String telefono){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    protected Usuarios(){
    }
}
