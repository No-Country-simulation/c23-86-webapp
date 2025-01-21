package com.callcenter.NoCountry.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IncidenciaDTO {
    private Integer idCliente;
    private Integer idServicio;
    private int prioridad;
    private String estado;
    private String descripcion;
    private LocalDateTime fechaDeAlta;
}
