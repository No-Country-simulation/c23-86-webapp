package com.callcenter.NoCountry.controller;

import com.callcenter.NoCountry.Exception.ControllerException;
import com.callcenter.NoCountry.entity.Clientes;
import com.callcenter.NoCountry.service.ClienteService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    private final ClienteService clienteService;
    @Autowired
    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }
    
    @PostMapping
    public ResponseEntity<List<Clientes>> buscarCliente(
                                                @RequestParam Long dni,
                                                @RequestParam String nombre,
                                                @RequestParam String apellido)
    {
        try{
        List<Clientes> clientes = new ArrayList<>();
        if (dni != null ){
             clientes = clienteService.buscarPorDni(dni);
        }else{
           /* if(nombre != null && apellido != null){
                    clientes = clienteService.BuscarPorNombreYApellido(nombre, apellido);
                    }*/
            if(nombre != null){
                clientes = clienteService.buscarPorNombre(nombre);
            }
            else if(apellido != null){
                clientes = clienteService.buscarPorApellido(apellido);
            }
            if (clientes.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }
        return ResponseEntity.ok(clientes);
        }catch(Exception e){
            throw new ControllerException("Cliente no encontrado", e);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Clientes> obtenerClientePorId(@PathVariable Long id){
        try{
            Optional<Clientes> cliente = clienteService.ObtenerPorId(id);
            if (cliente.isPresent()){
                return ResponseEntity.ok(cliente.get());
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }catch(Exception e){
            throw new ControllerException("No se encontro el Id", e);
        }
    }
}
