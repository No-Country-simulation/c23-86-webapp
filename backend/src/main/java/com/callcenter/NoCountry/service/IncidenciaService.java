package com.callcenter.NoCountry.service;

import com.callcenter.NoCountry.DTO.IncidenciaDTO;
import com.callcenter.NoCountry.entity.Clientes;
import com.callcenter.NoCountry.entity.Incidencias;
import com.callcenter.NoCountry.entity.Servicio;
import com.callcenter.NoCountry.repository.ClienteRepository;
import com.callcenter.NoCountry.repository.IncidenciaRepository;
import com.callcenter.NoCountry.repository.ServicioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class IncidenciaService {
    @Autowired
    private IncidenciaRepository incidenciaRepository;

    @Autowired
    private final ClienteRepository clienteRepository;

    @Autowired
    private final ServicioRepository servicioRepository;

    public Incidencias crearIncidencia(IncidenciaDTO incidenciaDTO) {
        // Verifica que el cliente exista
        Clientes cliente = (Clientes) clienteRepository.findById(incidenciaDTO.getIdCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        // Verifica que el servicio exista
        Servicio servicio = (Servicio) servicioRepository.findById(incidenciaDTO.getIdServicio())
                .orElseThrow(() -> new IllegalArgumentException("Servicio no encontrado"));

        // Crea la nueva incidencia
        Incidencias incidencia = new Incidencias();
        incidencia.setCliente(cliente);
        incidencia.setServicio(servicio);
        incidencia.setPrioridad(incidenciaDTO.getPrioridad());
        incidencia.setEstado(incidenciaDTO.getEstado());
        incidencia.setDescripcion(incidenciaDTO.getDescripcion());
        incidencia.setFechaDeAlta(LocalDateTime.now());

        return incidenciaRepository.save(incidencia);
    }
}
