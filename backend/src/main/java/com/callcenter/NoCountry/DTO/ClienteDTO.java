package com.callcenter.NoCountry.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import com.callcenter.NoCountry.entity.Clientes;

/**
 * Data Transfer Object (DTO) para representar los datos del cliente.
 * Esta clase sirve como un objeto intermedio para transferir información entre capas de la aplicación.
 */

@Getter
@Setter
public class ClienteDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long dni;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private String estado;
    
     /**
     * Constructor que crea un ClienteDTO a partir de una entidad {@link Clientes}.
     *
     * @param cliente Entidad {@link Clientes} de la cual se copiarán los datos para este DTO.
     */
    
    public ClienteDTO(){ 
    }
    
    public ClienteDTO(Clientes cliente) {
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.dni = cliente.getDni();
        this.correo = cliente.getCorreo();
        this.telefono = cliente.getTelefono();
        this.estado = cliente.getEstado();
    }
    
    public ClienteDTO(Long id, Long dni, String nombre, String apellido){
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
