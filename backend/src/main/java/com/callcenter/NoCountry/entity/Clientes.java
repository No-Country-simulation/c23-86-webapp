package com.callcenter.callcenter.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Clientes extends Usuarios{
    @NotBlank(message = "ingresar servicio")
    private String servicio;
    private String direccion;
    private String estado;
    private String metodoDePago;

    public Clientes(String nombre, String apellido, String correo, String telefono,LocalDateTime fechaAlta, LocalDateTime fechaBaja, String servicio, String direccion, String estado, String metodoDePago) {
        super(nombre, apellido, correo, telefono, fechaAlta, fechaBaja);
        this.servicio = servicio;
        this.direccion = direccion;
        this.estado = estado;
        this.metodoDePago = metodoDePago;
    }
    
}
