package com.callcenter.NoCountry.service;

import com.callcenter.NoCountry.DTO.DetalleIncidenciaDTO;
import com.callcenter.NoCountry.DTO.IncidenciaDTO;
import com.callcenter.NoCountry.entity.Clientes;
import com.callcenter.NoCountry.entity.DetalleIncidencias;
import com.callcenter.NoCountry.entity.Incidencias;
import com.callcenter.NoCountry.entity.Servicios;
import com.callcenter.NoCountry.repository.ClienteRepository;
import com.callcenter.NoCountry.repository.DetalleIncidenciaRepository;
import com.callcenter.NoCountry.repository.IncidenciaRepository;
import com.callcenter.NoCountry.repository.ServicioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servicio encargado de gestionar las incidencias, incluyendo la creación de nuevas incidencias,
 * la recuperación de detalles asociados a incidencias y la conversión de incidencias en DTOs.
 *
 * @author [Tu Nombre]
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class IncidenciaService {
    private final Logger logger = LoggerFactory.getLogger(IncidenciaService.class);
            
    @Autowired
    private final IncidenciaRepository incidenciaRepository;

    @Autowired
    private final ClienteRepository clienteRepository;

    @Autowired
    private final ServicioRepository servicioRepository;

    @Autowired
    private final DetalleIncidenciaRepository detalleIncidenciaRepository;

    /**
     * Crea una nueva incidencia en el sistema y la persiste en la base de datos.
     * También crea un detalle inicial para registrar la prioridad y el estado inicial de la incidencia.
     *
     * @param incidenciaDTO Objeto DTO que contiene los datos necesarios para crear una incidencia.
     * @return La incidencia creada y guardada en la base de datos.
     * @throws IllegalArgumentException Si el cliente o el servicio no existen.
     */
    public Incidencias crearIncidencia(IncidenciaDTO incidenciaDTO) {
        // Verifica que el cliente exista
        Clientes cliente = clienteRepository.findById(incidenciaDTO.getIdCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        // Verifica que el servicio exista
        Servicios servicio = servicioRepository.findById(incidenciaDTO.getIdServicio())
                .orElseThrow(() -> new IllegalArgumentException("Servicio no encontrado"));

        // Crea la nueva incidencia
        Incidencias incidencia = new Incidencias();
        incidencia.setCliente(cliente);
        incidencia.setServicio(servicio);
        incidencia.setDescripcion(incidenciaDTO.getDescripcion());
        incidencia.setFechaDeAlta(LocalDateTime.now());

        // Guarda la incidencia
        incidencia = incidenciaRepository.save(incidencia);
        return incidencia;
    }

    /**
     * Obtiene una incidencia junto con los detalles asociados.
     *
     * @param idIncidencia El ID de la incidencia a recuperar.
     * @return La incidencia con los detalles asociados.
     * @throws NoSuchElementException Si la incidencia con el ID proporcionado no existe.
     */
    public Incidencias obtenerIncidenciaConDetalles(Long idIncidencia) {
        // Buscar la incidencia
        Incidencias incidencia = incidenciaRepository.findById(idIncidencia)
                .orElseThrow(() -> new NoSuchElementException("Incidencia no encontrada"));

        // Obtener los detalles asociados
        List<DetalleIncidencias> detalles = detalleIncidenciaRepository.findByIncidencia_Id(idIncidencia);

        // Asignar los detalles a la incidencia
        incidencia.setDetalles(detalles);

        return incidencia;
    }
    
       public List<IncidenciaDTO> getIncidenciasFull(Long idCliente) {
        // Buscar la incidencia
        List<Incidencias> incidencias = incidenciaRepository.findByCliente_Id(idCliente);
        logger.info("Encuentra la lista de incidencias del cliente {}: {}", idCliente, incidencias.size());
        
        List<IncidenciaDTO> incidenciasDto = new ArrayList<>();
        for(Incidencias incidencia : incidencias){
            try{
            logger.info("ESTOY DENTRO DEL FOREACH");
            //Guarda cada incidencia
            IncidenciaDTO incidenciaDto = new IncidenciaDTO();
            incidenciaDto.setId(incidencia.getId());
            logger.info("{}", incidenciaDto.getId());
            incidenciaDto.setNombreCliente(incidencia.getCliente().getNombre());
            logger.info("{}", incidenciaDto.getNombreCliente());
            incidenciaDto.setApellidoCliente(incidencia.getCliente().getApellido());
            logger.info("{}", incidenciaDto.getApellidoCliente());
            incidenciaDto.setDescripcion(incidencia.getDescripcion());
            logger.info("{}", incidenciaDto.getDescripcion());
            incidenciaDto.setFechaDeAlta(incidencia.getFechaDeAlta());
            logger.info("{}", incidenciaDto.getFechaDeAlta());
            incidenciaDto.setNombreServicio(incidencia.getServicio().getNombre());
            logger.info("{}", incidenciaDto.getNombreServicio());
            
            //Buscar detalle de cada incidencia
            List<DetalleIncidencias> detalles = detalleIncidenciaRepository.findByIncidencia_Id(incidencia.getId());
            logger.info("Soy posterior a DetallesIncidencias");
            logger.info("Encuentra los detalles de cada incidencia: {}", detalles.size());
            List<DetalleIncidenciaDTO> detalleDto = detalles.stream()
                    .map(detalle -> new DetalleIncidenciaDTO(detalle)).collect(Collectors.toList());
            logger.info("detalle incidencia: {}", detalleDto.size());
            incidenciaDto.setDetalles(detalleDto);
            incidenciasDto.add(incidenciaDto);}
            catch(Exception e){
            logger.error("Error al procesar la incidencia ID: " + incidencia.getId(), e);
            }
        }
     logger.info("Lista de incidenciasDTO: {}", incidenciasDto.size());  
        return incidenciasDto;}

    
    /**
     * Obtiene la representación DTO de una incidencia.
     *
     * @param id El ID de la incidencia a convertir en DTO.
     * @return El DTO correspondiente a la incidencia.
     * @throws RuntimeException Si la incidencia con el ID proporcionado no existe.
     */
    public IncidenciaDTO obtenerIncidenciaDTO(Long id) {
        Incidencias incidencia = incidenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La incidencia con ID " + id + " no existe."));

        return new IncidenciaDTO(incidencia);
    }
}
