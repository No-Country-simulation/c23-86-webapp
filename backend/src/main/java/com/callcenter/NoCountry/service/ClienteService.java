
package com.callcenter.NoCountry.service;

import com.callcenter.NoCountry.DTO.ClienteDTO;
import com.callcenter.NoCountry.Exception.ServiceException;
import com.callcenter.NoCountry.entity.Clientes;
import com.callcenter.NoCountry.repository.ClienteRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    private final ClienteRepository clienteRepository;
    
    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    

    public List<Clientes> buscarPorDni(Long dni){
        try{
            return Collections.unmodifiableList(clienteRepository.findByDni(dni));
        }catch(Exception e){
            throw new ServiceException("No se encuentra el DNI", e);
        }
        
    }
    
    public List<Clientes> buscarPorNombre(String nombre){
        try{
            return clienteRepository.findByNombreContainingIgnoreCase(nombre);
        }catch(Exception e){
            throw new ServiceException("No se encuentra el nombre", e);
        }
    }
    
    public List<Clientes> buscarPorApellido(String apellido){
        try{
            return clienteRepository.findByApellidoContainingIgnoreCase(apellido);
        }catch(Exception e){
            throw new ServiceException("No se encuentra el apellido",e);
        }
    }

    public Clientes getClienteInfo(int idCliente) {
        Optional<Clientes> cliente = clienteRepository.findById(idCliente);
        return cliente.orElse(null);
    }

    public List<ClienteDTO> getClientes() {
        return clienteRepository.findAll().stream()
                .map(cliente -> new ClienteDTO(cliente))
                .collect(Collectors.toList());
    }
}
