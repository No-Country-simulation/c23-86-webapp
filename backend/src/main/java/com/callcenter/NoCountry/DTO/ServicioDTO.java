package com.callcenter.NoCountry.DTO;

import com.callcenter.NoCountry.entity.Servicios;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) para representar los datos de un servicio.
 * Esta clase se utiliza para transferir información de la entidad {@link Servicios} al cliente.
 */
@Data
@NoArgsConstructor
public class ServicioDTO {
    private Long id;
    private String nombre;
    private String descripcion;

    /**
     * Constructor que crea un objeto ServicioDTO a partir de una entidad {@link Servicios}.
     *
     * @param servicio Entidad {@link Servicios} que contiene los datos necesarios para inicializar este DTO.
     */
    public ServicioDTO(Servicios servicio) {
        this.id = servicio.getId();
        this.nombre = servicio.getNombre();
        this.descripcion = servicio.getDescripcion();
    }
}
