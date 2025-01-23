package com.callcenter.NoCountry.DTO;

import com.callcenter.NoCountry.entity.DetalleIncidencias;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class DetalleIncidenciaDTO {
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private Date fechaDeModificacion;
    private String descripcion;

    public DetalleIncidenciaDTO(DetalleIncidencias detalle) {
        this.nombreEmpleado = detalle.getEmpleado().getNombre();
        this.apellidoEmpleado = detalle.getEmpleado().getApellido();
        this.fechaDeModificacion = detalle.getFechaDeModificacion();
        this.descripcion = detalle.getDescripcion();
    }

}

