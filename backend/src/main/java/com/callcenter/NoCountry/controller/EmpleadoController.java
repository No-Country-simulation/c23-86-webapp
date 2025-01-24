package com.callcenter.NoCountry.controller;

import com.callcenter.NoCountry.entity.Empleados;
import com.callcenter.NoCountry.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService  empleadoService;
    
    @PostMapping
    public ResponseEntity<String> crearEmpleado(@RequestBody Empleados empleado){
        empleadoService.createEmpleado(empleado);    
        return ResponseEntity.ok("empleado creado");
        
    }
    
    
}
