package com.callcenter.NoCountry.DTO;

import com.callcenter.NoCountry.entity.Clientes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) para representar los datos del cliente.
 * Esta clase sirve como un objeto intermedio para transferir información entre capas de la aplicación.
 */
@Data
@NoArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Long dni;
    private String correo;
    private String telefono;
    @JsonIgnore
    private String estado;

    /**
     * Constructor que crea un ClienteDTO a partir de una entidad {@link Clientes}.
     *
     * @param cliente Entidad {@link Clientes} de la cual se copiarán los datos para este DTO.
     */
    public ClienteDTO(Clientes cliente) {
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.dni = cliente.getDni();
        this.correo = cliente.getCorreo();
        this.telefono = cliente.getTelefono();
        this.estado = cliente.getEstado();
    }
}
