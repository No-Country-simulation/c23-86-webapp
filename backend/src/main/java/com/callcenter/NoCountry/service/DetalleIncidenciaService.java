package com.callcenter.NoCountry.service;

import com.callcenter.NoCountry.DTO.DetalleIncidenciaDTO;
import com.callcenter.NoCountry.entity.DetalleIncidencias;
import com.callcenter.NoCountry.entity.Incidencias;
import com.callcenter.NoCountry.repository.DetalleIncidenciaRepository;
import com.callcenter.NoCountry.repository.EmpleadoRepository;
import com.callcenter.NoCountry.repository.IncidenciaRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalleIncidenciaService {

    private final IncidenciaRepository incidenciaRepository;
    private final DetalleIncidenciaRepository detalleIncidenciaRepository;
    private final EmpleadoRepository empleadoRepository;

    public DetalleIncidenciaService(IncidenciaRepository incidenciaRepository, DetalleIncidenciaRepository detalleIncidenciaRepository, EmpleadoRepository empleadoRepository) {
        this.incidenciaRepository = incidenciaRepository;
        this.detalleIncidenciaRepository = detalleIncidenciaRepository;
        this.empleadoRepository = empleadoRepository;
    }

    public DetalleIncidencias crearDetalle(Long idIncidencia, DetalleIncidenciaDTO detalleDTO) {
        Incidencias incidencia = incidenciaRepository.findById(idIncidencia)
                .orElseThrow(() -> new IllegalArgumentException("La incidencia no existe"));

        // Crear y asociar el detalle
        DetalleIncidencias detalle = new DetalleIncidencias();
        detalle.setIncidencia(incidencia);
        //detalle.setEmpleado(empleadoRepository.getReferenceById(detalleDTO.getIdEmpleado());
        detalle.setDescripcion(detalleDTO.getDescripcion());

        // Guardar el detalle en la base de datos
        return detalleIncidenciaRepository.save(detalle);
    }
}

