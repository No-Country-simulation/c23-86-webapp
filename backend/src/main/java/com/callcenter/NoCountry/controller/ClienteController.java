package com.callcenter.NoCountry.controller;

import com.callcenter.NoCountry.DTO.ClienteDTO;
import com.callcenter.NoCountry.Exception.ControllerException;
import com.callcenter.NoCountry.entity.Clientes;
import com.callcenter.NoCountry.service.ClienteService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.callcenter.NoCountry.entity.Clientes;
import com.callcenter.NoCountry.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    private final ClienteService clienteService;
    @Autowired
    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }
    
    @PostMapping
    public ResponseEntity<List<ClienteDTO>> buscarCliente(
                                                @RequestParam(required = false) Long dni,
                                                @RequestParam(required = false) String nombre,
                                                @RequestParam(required = false) String apellido)
    {
        try{
        List<Clientes> clientes = new ArrayList<>();
        if (dni != null ){
             clientes = clienteService.buscarPorDni(dni);
        }else{
            if(nombre != null && apellido != null){
                    clientes = clienteService.buscarPorNombreYApellido(nombre, apellido);
                    }
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
        List<ClienteDTO> clienteDTOs = clientes.stream()
                .map(cliente -> new ClienteDTO(
                        cliente.getId(),
                        cliente.getDni(), 
                        cliente.getNombre(), 
                        cliente.getApellido())
                ).collect(Collectors.toList());
        
        return ResponseEntity.ok(clienteDTOs);
        }catch(Exception e){
            throw new ControllerException("Cliente no encontrado", e);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable Long id){
        try{
            Optional<Clientes> cliente = clienteService.ObtenerPorId(id);
            if (cliente.isPresent()){
                ClienteDTO clienteDto = new ClienteDTO();
                
                clienteDto.setId(cliente.get().getId());
                clienteDto.setDni(cliente.get().getDni());
                clienteDto.setNombre(cliente.get().getNombre());
                clienteDto.setApellido(cliente.get().getApellido());
                clienteDto.setCorreo(cliente.get().getCorreo());
                clienteDto.setDireccion(cliente.get().getDireccion());
                clienteDto.setTelefono(cliente.get().getTelefono());
                clienteDto.setEstado(cliente.get().getEstado());
                
                return ResponseEntity.ok(clienteDto);
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }catch(Exception e){
            throw new ControllerException("No se encontro el Id", e);
        }
    }
}
   /* @GetMapping("/{id}")
    public Clientes getClienteInfo(@PathVariable int id) {
        return clienteService.getClienteInfo(id);
    }*/

