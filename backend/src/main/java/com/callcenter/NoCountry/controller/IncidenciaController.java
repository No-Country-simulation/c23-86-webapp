package com.callcenter.NoCountry.controller;

import com.callcenter.NoCountry.DTO.IncidenciaDTO;
import com.callcenter.NoCountry.entity.Incidencias;
import com.callcenter.NoCountry.service.IncidenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/incidencia")
public class IncidenciaController {

    private final IncidenciaService incidenciaService;

    public IncidenciaController(IncidenciaService incidenciaService) {
        this.incidenciaService = incidenciaService;
    }

    @PostMapping
    public ResponseEntity<Incidencias> crearIncidencia(@RequestBody IncidenciaDTO incidenciaDTO) {
        Incidencias nuevaIncidencia = incidenciaService.crearIncidencia(incidenciaDTO);
        return new ResponseEntity<>(nuevaIncidencia, HttpStatus.CREATED);
    }
}
