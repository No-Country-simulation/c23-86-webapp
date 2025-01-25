package com.callcenter.NoCountry.controller;

import com.callcenter.NoCountry.DTO.DetalleIncidenciaDTO;
import com.callcenter.NoCountry.DTO.IncidenciaDTO;
import com.callcenter.NoCountry.entity.Incidencias;
import com.callcenter.NoCountry.service.DetalleIncidenciaService;
import com.callcenter.NoCountry.service.IncidenciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar las operaciones relacionadas con las incidencias y sus detalles.
 * Proporciona endpoints para crear, consultar y actualizar incidencias.
 */
@RestController
@RequestMapping("/incidencia")
@Tag(name = "Incidencia", description = "Controlador para gestionar las incidencias")
public class IncidenciaController {

    private final IncidenciaService incidenciaService;
    private final DetalleIncidenciaService detalleIncidenciaService;

    /**
     * Constructor de la clase `IncidenciaController`.
     *
     * @param incidenciaService         Servicio encargado de la lógica de negocio para las incidencias.
     * @param detalleIncidenciaService  Servicio encargado de la lógica de negocio para los detalles de incidencias.
     */
    public IncidenciaController(IncidenciaService incidenciaService, DetalleIncidenciaService detalleIncidenciaService) {
        this.incidenciaService = incidenciaService;
        this.detalleIncidenciaService = detalleIncidenciaService;
    }


    /**
     * Endpoint para crear una nueva incidencia.
     *
     * @param incidenciaDTO Objeto que contiene los datos necesarios para crear la incidencia.
     * @return Respuesta HTTP con la incidencia creada y el código de estado {@code 201 (CREATED)}.
     */
    @Operation(summary = "Crear una nueva incidencia", description = "Crea una incidencia en el sistema con la información proporcionada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Incidencia creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping
    public ResponseEntity<IncidenciaDTO> crearIncidencia(@RequestBody IncidenciaDTO incidenciaDTO) {
        Incidencias nuevaIncidencia = incidenciaService.crearIncidencia(incidenciaDTO);
        IncidenciaDTO incidenciaDTO1 = new IncidenciaDTO(nuevaIncidencia);
        return new ResponseEntity<>(incidenciaDTO1, HttpStatus.CREATED);
    }

    /**
     * Endpoint para obtener una incidencia por su ID.
     *
     * @param id Identificador único de la incidencia.
     * @return Respuesta HTTP con la información de la incidencia solicitada y el código de estado {@code 200 (OK)}.
     */
    @Operation(summary = "Obtener incidencia por ID", description = "Recupera los detalles de una incidencia especificada por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Incidencia encontrada"),
            @ApiResponse(responseCode = "404", description = "Incidencia no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<IncidenciaDTO> obtenerIncidenciaPorId(@PathVariable Long id) {
        IncidenciaDTO incidenciaDTO = incidenciaService.obtenerIncidenciaDTO(id);
        return ResponseEntity.ok(incidenciaDTO);
    }

    /**
     * Endpoint para agregar un detalle a una incidencia existente.
     *
     * @param idIncidencia ID de la incidencia a la que se desea agregar un detalle.
     * @param detalleDTO   Objeto que contiene los datos del detalle que se va a agregar.
     * @return Respuesta HTTP con la incidencia actualizada o un mensaje de error en caso de fallo.
     *         Retorna:
     *         <ul>
     *             <li>{@code 201 (CREATED)} si el detalle se agregó correctamente.</li>
     *             <li>{@code 400 (BAD REQUEST)} si hay un error en los datos proporcionados.</li>
     *             <li>{@code 500 (INTERNAL SERVER ERROR)} si ocurre un error interno en el servidor.</li>
     *         </ul>
     */
    @Operation(summary = "Agregar un detalle a una incidencia", description = "Agrega un detalle a una incidencia existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Detalle agregado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos o incidencia no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("/{idIncidencia}/detalles")
    public ResponseEntity<?> agregarDetalle(@PathVariable Long idIncidencia, @RequestBody DetalleIncidenciaDTO detalleDTO) {
        try {
            detalleIncidenciaService.crearDetalle(idIncidencia, detalleDTO);

            IncidenciaDTO incidenciaDTO = incidenciaService.obtenerIncidenciaDTO(idIncidencia);
            return ResponseEntity.status(HttpStatus.CREATED).body(incidenciaDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
        }
//    }    /**
//     * Endpoint para agregar un detalle a una incidencia existente.
//     *
//     * @param idIncidencia ID de la incidencia a la que se desea agregar un detalle.
//     * @param detalleDTO   Objeto que contiene los datos del detalle que se va a agregar.
//     * @return Respuesta HTTP con la incidencia actualizada o un mensaje de error en caso de fallo.
//     *         Retorna:
//     *         <ul>
//     *             <li>{@code 201 (CREATED)} si el detalle se agregó correctamente.</li>
//     *             <li>{@code 400 (BAD REQUEST)} si hay un error en los datos proporcionados.</li>
//     *             <li>{@code 500 (INTERNAL SERVER ERROR)} si ocurre un error interno en el servidor.</li>
//     *         </ul>
//     */
//    @Operation(summary = "Agregar un detalle a una incidencia", description = "Agrega un detalle a una incidencia existente")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Detalle agregado exitosamente"),
//            @ApiResponse(responseCode = "400", description = "Datos inválidos o incidencia no encontrada"),
//            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
//    })
//    @PostMapping("/{idIncidencia}/detalles")
//    public ResponseEntity<?> agregarDetalle(@PathVariable Long idIncidencia, @RequestBody DetalleIncidenciaDTO detalleDTO) {
//        try {
//            detalleIncidenciaService.crearDetalle(idIncidencia, detalleDTO);
//
//            IncidenciaDTO incidenciaDTO = incidenciaService.obtenerIncidenciaDTO(idIncidencia);
//            return ResponseEntity.status(HttpStatus.CREATED).body(incidenciaDTO);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
//        }
//    }
}
