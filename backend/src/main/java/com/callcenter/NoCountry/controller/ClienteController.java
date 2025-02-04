package com.callcenter.NoCountry.controller;

import com.callcenter.NoCountry.DTO.ClienteCompletoDTO;
import com.callcenter.NoCountry.entity.Clientes;
import com.callcenter.NoCountry.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ClienteCompletoDTO getClienteInfo(@PathVariable int id) {
        return new ClienteCompletoDTO(clienteService.getClienteInfo(id));
    }
    
    @GetMapping("")
    public List<Clientes> getClientes(){
        return clienteService.getClientes();
    }
}

