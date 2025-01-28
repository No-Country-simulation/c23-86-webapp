package com.callcenter.NoCountry.DTO;

import com.callcenter.NoCountry.entity.DetalleIncidencias;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) para representar los detalles de una incidencia.
 * Esta clase sirve para transferir información relacionada con las modificaciones de una incidencia,
 * realizada por un empleado.
 */
@Data
@NoArgsConstructor
public class DetalleIncidenciaDTO {
    private Long idEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private LocalDateTime fechaDeModificacion;
    private String descripcion;
    private String estado; // Nuevo campo para el estado de la incidencia
    private int prioridad; // Nuevo campo para la prioridad de la incidencia

    /**
     * Constructor que crea un DetalleIncidenciaDTO a partir de una entidad {@link DetalleIncidencias}.
     *
     * @param detalle Entidad {@link DetalleIncidencias} que contiene los datos necesarios para inicializar este DTO.
     */
    public DetalleIncidenciaDTO(DetalleIncidencias detalle) {
        this.idEmpleado = detalle.getEmpleado().getId();
        this.nombreEmpleado = detalle.getEmpleado().getNombre();
        this.apellidoEmpleado = detalle.getEmpleado().getApellido();
        this.fechaDeModificacion = detalle.getFechaDeModificacion();
        this.descripcion = detalle.getDescripcion();
        this.estado = detalle.getEstado(); // Asignación del nuevo campo
        this.prioridad = detalle.getPrioridad(); // Asignación del nuevo campo
    }
}


