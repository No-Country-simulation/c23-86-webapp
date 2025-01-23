package com.callcenter.NoCountry.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DetalleIncidenciaDTO {
    private Long idEmpleado;
    private LocalDate fechaDeModificacion;
    private String descripcion;
}

