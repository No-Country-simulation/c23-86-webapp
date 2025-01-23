package com.callcenter.NoCountry.DTO;

import com.callcenter.NoCountry.entity.Incidencias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncidenciaDTO {
    private Long id;
    private Long idCliente;
    private Long idServicio;
    private ClienteDTO cliente;
    private ServicioDTO servicio;
    private int prioridad;
    private String estado;
    private String descripcion;
    private LocalDateTime fechaDeAlta;
    private List<DetalleIncidenciaDTO> detalles;

    // Constructor
    public IncidenciaDTO(Incidencias incidencia) {
        this.id = incidencia.getId();
        this.idCliente = incidencia.getCliente().getId();
        this.idServicio = incidencia.getServicio().getId();
        this.prioridad = incidencia.getPrioridad();
        this.estado = incidencia.getEstado();
        this.descripcion = incidencia.getDescripcion();
        this.fechaDeAlta = incidencia.getFechaDeAlta();

        // Mapear Cliente
        this.cliente = new ClienteDTO(incidencia.getCliente());

        // Mapear Servicio
        this.servicio = new ServicioDTO(incidencia.getServicio());

        // Mapear Detalles
        this.detalles = incidencia.getDetalles().stream()
                .map(DetalleIncidenciaDTO::new) // Usar constructor de DetalleIncidenciaDTO
                .collect(Collectors.toList());
    }
}
