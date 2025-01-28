package com.callcenter.NoCountry.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@Table(name = "clientes")
public class Clientes extends Usuarios{
    @NotBlank(message = "Ingrese direccion")
    private String direccion;
    
    private String estado = "activo";

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<ClienteServicio> servicios;
    
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Incidencias> incidencias;
    
    public Clientes(Long dni, String nombre, String apellido, String correo, String telefono,String direccion) {
        super(dni, nombre, apellido, correo, telefono);
        this.direccion = direccion;
    }
    
    public Clientes(){
    }


}