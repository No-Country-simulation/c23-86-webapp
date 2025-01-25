package com.callcenter.NoCountry.DTO;

import com.callcenter.NoCountry.entity.DetalleIncidencias;
import com.callcenter.NoCountry.entity.Incidencias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Data Transfer Object (DTO) para representar una incidencia y sus detalles asociados.
 * Esta clase sirve para transferir información de la entidad {@link Incidencias} al cliente.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncidenciaDTO {
    private Long id;
    private Long idCliente;
    private Long idServicio;
    private ClienteDTO cliente;
    private ServicioDTO servicio;
    private String descripcion;
    private LocalDateTime fechaDeAlta;
    private List<DetalleIncidenciaDTO> detalles;

    /**
     * Constructor que crea un objeto IncidenciaDTO a partir de una entidad {@link Incidencias}.
     *
     * @param incidencia Entidad {@link Incidencias} que contiene los datos necesarios para inicializar este DTO.
     */
    public IncidenciaDTO(Incidencias incidencia) {
        this.id = incidencia.getId();
        this.idCliente = incidencia.getCliente().getId();
        this.idServicio = incidencia.getServicio().getId();
        this.descripcion = incidencia.getDescripcion();
        this.fechaDeAlta = incidencia.getFechaDeAlta();
        this.cliente = new ClienteDTO(incidencia.getCliente());

        // Mapear Servicio
        this.servicio = new ServicioDTO(incidencia.getServicio());

        // Mapear Detalles
        this.detalles = incidencia.getDetalles() == null || incidencia.getDetalles().isEmpty()
                ? Collections.emptyList()
                : incidencia.getDetalles().stream()
                .map(DetalleIncidenciaDTO::new) // Usar constructor de DetalleIncidenciaDTO
                .collect(Collectors.toList());
    }
}

