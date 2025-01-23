package com.callcenter.NoCountry.controller;

import com.callcenter.NoCountry.DTO.DetalleIncidenciaDTO;
import com.callcenter.NoCountry.DTO.IncidenciaDTO;
import com.callcenter.NoCountry.entity.DetalleIncidencias;
import com.callcenter.NoCountry.entity.Incidencias;
import com.callcenter.NoCountry.service.DetalleIncidenciaService;
import com.callcenter.NoCountry.service.IncidenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/incidencia")
public class IncidenciaController {

    private final IncidenciaService incidenciaService;
    private final DetalleIncidenciaService detalleIncidenciaService;

    public IncidenciaController(IncidenciaService incidenciaService, DetalleIncidenciaService detalleIncidenciaService) {
        this.incidenciaService = incidenciaService;
        this.detalleIncidenciaService = detalleIncidenciaService;
    }


    /**
     * Endpoint para crear una nueva incidencia.
     *
     * <p>Este método maneja solicitudes HTTP POST para crear una incidencia en el sistema.
     * Recibe los datos necesarios para la incidencia en el cuerpo de la solicitud como un objeto {@link IncidenciaDTO}.
     * Después de procesar la solicitud, crea una nueva incidencia y la guarda en la base de datos.
     *
     * @param incidenciaDTO el objeto que contiene los datos necesarios para crear una nueva incidencia.
     * @return una respuesta HTTP que incluye:
     * - Código de estado 201 (CREATED) si la incidencia se creó exitosamente.
     * - El objeto {@link Incidencias} recién creado en el cuerpo de la respuesta.
     */


    @PostMapping
    public ResponseEntity<Incidencias> crearIncidencia(@RequestBody IncidenciaDTO incidenciaDTO) {
        Incidencias nuevaIncidencia = incidenciaService.crearIncidencia(incidenciaDTO);
        return new ResponseEntity<>(nuevaIncidencia, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidenciaDTO> obtenerIncidenciaPorId(@PathVariable Long id) {
        IncidenciaDTO incidenciaDTO = incidenciaService.obtenerIncidenciaDTO(id);
        return ResponseEntity.ok(incidenciaDTO);
    }


    @PostMapping("/{idIncidencia}/detalles")
    public ResponseEntity<?> agregarDetalle(@PathVariable Long idIncidencia, @RequestBody DetalleIncidenciaDTO detalleDTO) {
        try {
            DetalleIncidencias detalleCreado = detalleIncidenciaService.crearDetalle(idIncidencia, detalleDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(detalleCreado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }
}
