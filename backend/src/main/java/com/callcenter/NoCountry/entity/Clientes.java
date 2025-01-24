package com.callcenter.NoCountry.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
@Table(name = "clientes")
public class Clientes extends Usuarios{
    @NotBlank(message = "Ingrese direccion")
    private String direccion;
    private String estado = "activo";

    @OneToMany(mappedBy = "idCliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClienteServicio> clienteServicios;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Incidencias> incidencias;
    
    public Clientes(Long dni, String nombre, String apellido, String correo, String telefono,String direccion) {
        super(dni, nombre, apellido, correo, telefono);
        this.direccion = direccion;
    }
    
    public Clientes(){
    }

}