package com.callcenter.NoCountry.DTO;

import com.callcenter.NoCountry.entity.Servicios;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServicioDTO {
    private Long id;
    private String nombre;
    private String descripcion;

    public ServicioDTO(Servicios servicio) {
        this.id = servicio.getId();
        this.nombre = servicio.getNombre();
        this.descripcion = servicio.getDescripcion();
    }

}
