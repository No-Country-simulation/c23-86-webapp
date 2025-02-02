package com.callcenter.NoCountry.DTO;

import com.callcenter.NoCountry.entity.ClienteServicio;
import com.callcenter.NoCountry.entity.Servicios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Data Transfer Object (DTO) para representar los datos de un servicio.
 * Esta clase se utiliza para transferir información de la entidad {@link Servicios} al cliente.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicioDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private LocalDateTime fechaAlta;
    private BigDecimal monto;
    private List<HistorialPagoDTO> historialPagos;

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

    public ServicioDTO(ClienteServicio clienteServicio) {
        Servicios servicio = clienteServicio.getServicio();
        this.nombre = servicio.getNombre();
        this.descripcion = servicio.getDescripcion();
        this.precio = servicio.getPrecio();
        this.fechaAlta = clienteServicio.getFechaAlta();
        this.monto = clienteServicio.getMonto();
        this.historialPagos = clienteServicio.getHistorialPagos().stream()
                .map(HistorialPagoDTO::new)
                .collect(Collectors.toList());
    }

    public ServicioDTO(String nombre, String descripcion, BigDecimal precio,
                       LocalDateTime fechaAlta, BigDecimal monto, List<HistorialPagoDTO> historialPagos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaAlta = fechaAlta;
        this.monto = monto;
        this.historialPagos = historialPagos;
    }

}
