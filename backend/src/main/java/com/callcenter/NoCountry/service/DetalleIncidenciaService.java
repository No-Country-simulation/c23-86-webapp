package com.callcenter.NoCountry.service;

import com.callcenter.NoCountry.DTO.DetalleIncidenciaDTO;
import com.callcenter.NoCountry.entity.DetalleIncidencias;
import com.callcenter.NoCountry.entity.Empleados;
import com.callcenter.NoCountry.entity.Incidencias;
import com.callcenter.NoCountry.repository.DetalleIncidenciaRepository;
import com.callcenter.NoCountry.repository.EmpleadoRepository;
import com.callcenter.NoCountry.repository.IncidenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
     * @param incidenciaRepository         Repositorio de incidencias.
     * @param detalleIncidenciaRepository  Repositorio de detalles de incidencia.
     * @param empleadoRepository           Repositorio de empleados.
     */
    public DetalleIncidenciaService(IncidenciaRepository incidenciaRepository,
                                    DetalleIncidenciaRepository detalleIncidenciaRepository,
                                    EmpleadoRepository empleadoRepository) {
        this.incidenciaRepository = incidenciaRepository;
        this.detalleIncidenciaRepository = detalleIncidenciaRepository;
        this.empleadoRepository = empleadoRepository;
    }

    /**
     * Crea un nuevo detalle para una incidencia específica.
     *
     * Este método crea y persiste un nuevo detalle de incidencia, asociando
     * una incidencia, un empleado, prioridad y estado.
     * La fecha de modificacion se setea a la fecha actual.
     *
     * @param idIncidencia El ID de la incidencia a la que se le asociará el detalle.
     * @param detalleDTO    El objeto que contiene la información del detalle a crear.
     * @return El detalle de incidencia creado y guardado en la base de datos.
     * @throws IllegalArgumentException Si la incidencia con el ID proporcionado no existe.
     */
    public DetalleIncidencias crearDetalle(Long idIncidencia, DetalleIncidenciaDTO detalleDTO) {
        // Validar que la incidencia existe
        Incidencias incidencia = incidenciaRepository.findById(idIncidencia)
                .orElseThrow(() -> new IllegalArgumentException("La incidencia no existe"));

        // Validar que el empleado existe
        Empleados empleado = empleadoRepository.findById(detalleDTO.getIdEmpleado())
                .orElseThrow(() -> new IllegalArgumentException("El empleado no existe"));

        // Crear el detalle de incidencia
        DetalleIncidencias detalle = new DetalleIncidencias();
        detalle.setIncidencia(incidencia);
        detalle.setEmpleado(empleado);
        detalle.setFechaDeModificacion(LocalDateTime.now());
        detalle.setDescripcion(detalleDTO.getDescripcion());
        detalle.setPrioridad(detalleDTO.getPrioridad());
        detalle.setEstado(detalleDTO.getEstado());

        // Guardar el detalle en la base de datos
        return detalleIncidenciaRepository.save(detalle);
    }

    /**
     * Obtiene todos los detalles asociados a una incidencia.
     *
     * @param idIncidencia El ID de la incidencia.
     * @return Lista de detalles de la incidencia.
     */
    public List<DetalleIncidencias> obtenerDetallesPorIncidencia(Long idIncidencia) {
        return detalleIncidenciaRepository.findByIncidenciaId(idIncidencia);
    }

    /**
     * Actualiza un detalle de una incidencia.
     *
     * @param idDetalle     El ID del detalle a actualizar.
     * @param detalleDTO    Datos actualizados para el detalle.
     * @param prioridad     Nueva prioridad.
     * @param estado        Nuevo estado.
     * @return El detalle actualizado.
     * @throws IllegalArgumentException Si el detalle o el empleado no existen.
     */
    public DetalleIncidencias actualizarDetalle(Long idDetalle, DetalleIncidenciaDTO detalleDTO, int prioridad, String estado) {
        DetalleIncidencias detalle = detalleIncidenciaRepository.findById(idDetalle)
                .orElseThrow(() -> new IllegalArgumentException("El detalle no existe"));

        // Validar que el empleado existe
        Empleados empleado = empleadoRepository.findById(detalleDTO.getIdEmpleado())
                .orElseThrow(() -> new IllegalArgumentException("El empleado no existe"));

        // Actualizar el detalle
        detalle.setEmpleado(empleado);
        detalle.setDescripcion(detalleDTO.getDescripcion());
        detalle.setFechaDeModificacion(LocalDateTime.now());
        detalle.setPrioridad(prioridad);
        detalle.setEstado(estado);

        // Guardar los cambios
        return detalleIncidenciaRepository.save(detalle);
    }
}


