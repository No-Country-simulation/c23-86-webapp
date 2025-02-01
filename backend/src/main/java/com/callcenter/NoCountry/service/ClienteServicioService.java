package com.callcenter.NoCountry.service;

import com.callcenter.NoCountry.DTO.ClienteServicioDTO;
import com.callcenter.NoCountry.entity.ClienteServicio;
import com.callcenter.NoCountry.repository.ClienteServicioRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicioService {
    
    private static final Logger logger = LoggerFactory.getLogger(ClienteServicioService.class);
    
    @Autowired
    private ClienteServicioRepository clienteServRepo;
    
    public List<ClienteServicioDTO> getClienteServicio(Long id){
        logger.info("Buscando servicios para cliente con ID: {}", id);
        List<ClienteServicio> servicios = clienteServRepo.findByCliente_id(id);
        logger.info("Servicios encontrados: {}", servicios.size());
        
         List<ClienteServicioDTO> serviciosDTO = servicios.stream()
                .map(servicio -> new ClienteServicioDTO(servicio))
                    .collect(Collectors.toList());
         
         logger.info("Servicios guardados en el DTO: {}", serviciosDTO.size());
         
         return serviciosDTO;
    }
}
