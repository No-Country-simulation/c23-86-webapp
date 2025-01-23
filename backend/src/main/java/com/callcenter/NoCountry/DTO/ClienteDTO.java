package com.callcenter.NoCountry.DTO;

import com.callcenter.NoCountry.entity.Clientes;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Long dni;
    private String correo;
    private String telefono;
    private String estado;

    public ClienteDTO(Clientes cliente) {
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
    }
}
