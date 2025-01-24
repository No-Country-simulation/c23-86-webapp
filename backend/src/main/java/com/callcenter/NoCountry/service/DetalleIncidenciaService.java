package com.callcenter.NoCountry.service;

import com.callcenter.NoCountry.DTO.DetalleIncidenciaDTO;
import com.callcenter.NoCountry.entity.DetalleIncidencias;
import com.callcenter.NoCountry.entity.Incidencias;
import com.callcenter.NoCountry.repository.DetalleIncidenciaRepository;
import com.callcenter.NoCountry.repository.EmpleadoRepository;
import com.callcenter.NoCountry.repository.IncidenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Servicio encargado de gestionar los detalles de las incidencias.
 * Esta clase maneja la creación y persistencia de los detalles de incidencias,
 * asociando los detalles a una incidencia y un empleado específico.
 *
 */
@Service
public class DetalleIncidenciaService {

    private final IncidenciaRepository incidenciaRepository;
    private final DetalleIncidenciaRepository detalleIncidenciaRepository;
    private final EmpleadoRepository empleadoRepository;

    /**
     * Constructor del servicio de detalles de incidencia.
     *
     * @param incidenciaRepository Repositorio de incidencias.
     * @param detalleIncidenciaRepository Repositorio de detalles de incidencia.
     * @param empleadoRepository Repositorio de empleados.
     */
    public DetalleIncidenciaService(IncidenciaRepository incidenciaRepository, DetalleIncidenciaRepository detalleIncidenciaRepository, EmpleadoRepository empleadoRepository) {
        this.incidenciaRepository = incidenciaRepository;
        this.detalleIncidenciaRepository = detalleIncidenciaRepository;
        this.empleadoRepository = empleadoRepository;
    }

    /**
     * Crea un nuevo detalle para una incidencia específica.
     *
     * Este método crea y persiste un nuevo detalle de incidencia, asociando
     * una incidencia, un empleado y una descripción proporcionada.
     *
     * @param idIncidencia El ID de la incidencia a la que se le asociará el detalle.
     * @param detalleDTO El objeto que contiene la información del detalle a crear.
     * @return El detalle de incidencia creado y guardado en la base de datos.
     * @throws IllegalArgumentException Si la incidencia con el ID proporcionado no existe.
     */
    public DetalleIncidencias crearDetalle(Long idIncidencia, DetalleIncidenciaDTO detalleDTO) {
        Incidencias incidencia = incidenciaRepository.findById(idIncidencia)
                .orElseThrow(() -> new IllegalArgumentException("La incidencia no existe"));

        // Crear y asociar el detalle
        DetalleIncidencias detalle = new DetalleIncidencias();
        detalle.setIncidencia(incidencia);
        //detalle.setEmpleado(empleadoRepository.getReferenceById(detalleDTO.getIdEmpleado());
        detalle.setEmpleado(empleadoRepository.getReferenceById(detalleDTO.getIdEmpleado()));
        detalle.setFechaDeModificacion(LocalDateTime.now());
        detalle.setDescripcion(detalleDTO.getDescripcion());

        // Guardar el detalle en la base de datos
        return detalleIncidenciaRepository.save(detalle);
    }
}

