/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.NoCountry.controller;

import com.callcenter.NoCountry.entity.DetalleIncidencias;
import com.callcenter.NoCountry.service.DetalleIncidenciaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalles")
public class DetalleIncidenciaController {
    
    @Autowired
    private DetalleIncidenciaService detalleServ;
    
    
    @GetMapping("/{id}")
    public Optional<DetalleIncidencias> getDetalles(@PathVariable Long id){
        return detalleServ.obtenerPorId(id);
        
    }
}
