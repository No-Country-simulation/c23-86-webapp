package com.callcenter.NoCountry.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
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

    @OneToMany(mappedBy = "id_Cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClienteServicio> clienteServicios;
    
    public Clientes(String nombre, String apellido, String correo, String telefono,LocalDateTime fechaAlta, LocalDateTime fechaBaja, String servicio, String direccion, String estado, String metodoDePago) {
        super(nombre, apellido, correo, telefono, fechaAlta);
        this.servicio = servicio;
        this.direccion = direccion;
        this.estado = estado;
        this.metodoDePago = metodoDePago;
    }

}