package com.callcenter.NoCountry.service;

import com.callcenter.NoCountry.DTO.ClienteDTO;
import com.callcenter.NoCountry.DTO.DetalleIncidenciaDTO;
import com.callcenter.NoCountry.DTO.IncidenciaDTO;
import com.callcenter.NoCountry.DTO.ServicioDTO;
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
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class IncidenciaService {
    @Autowired
    private IncidenciaRepository incidenciaRepository;

    @Autowired
    private final ClienteRepository clienteRepository;

    @Autowired
    private final ServicioRepository servicioRepository;

    @Autowired
    private DetalleIncidenciaRepository detalleIncidenciaRepository;

    public Incidencias crearIncidencia(IncidenciaDTO incidenciaDTO) {
        // Verifica que el cliente exista
        Clientes cliente = clienteRepository.findById(incidenciaDTO.getIdCliente()).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        // Verifica que el servicio exista
        Servicios servicio = servicioRepository.findById(incidenciaDTO.getIdServicio()).orElseThrow(() -> new IllegalArgumentException("Servicio no encontrado"));

        // Crea la nueva incidencia
        Incidencias incidencia = new Incidencias();
        incidencia.setCliente(cliente);
        incidencia.setServicio(servicio);
        incidencia.setPrioridad(incidenciaDTO.getPrioridad());
        incidencia.setEstado(incidenciaDTO.getEstado());
        incidencia.setDescripcion(incidenciaDTO.getDescripcion());
        incidencia.setFechaDeAlta(LocalDateTime.now());

        // Guarda la incidencia en la base de datos
        return incidenciaRepository.save(incidencia);
    }


    public Incidencias obtenerIncidenciaConDetalles(Long idIncidencia) {
        // Buscar la incidencia
        Incidencias incidencia = incidenciaRepository.findById(idIncidencia).orElseThrow(() -> new NoSuchElementException("Incidencia no encontrada"));

        // Obtener los detalles asociados
        List<DetalleIncidencias> detalles = detalleIncidenciaRepository.findByIncidenciaId(idIncidencia);

        // Asignar los detalles a la incidencia
        incidencia.setDetalles(detalles);

        return incidencia;
    }


    public IncidenciaDTO obtenerIncidenciaDTO(Long id) {
        Incidencias incidencia = (Incidencias) incidenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("La incidencia con ID " + id + " no existe."));

        return new IncidenciaDTO(incidencia);
    }

}