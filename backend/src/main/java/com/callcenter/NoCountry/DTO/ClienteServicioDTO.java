
package com.callcenter.NoCountry.DTO;

import com.callcenter.NoCountry.entity.ClienteServicio;
import com.callcenter.NoCountry.entity.Clientes;
import com.callcenter.NoCountry.entity.Servicios;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClienteServicioDTO {

    private Long id;
    
    private BigDecimal monto;

    private LocalDateTime fechaAlta;
    
    private Long iDservicio;
    
    private String nombreServicio;
        
    public ClienteServicioDTO(){     
    }
    
    public ClienteServicioDTO(ClienteServicio clienteServicio){
        id = clienteServicio.getId();
        monto = clienteServicio.getMonto();
        fechaAlta = clienteServicio.getFechaAlta();
        iDservicio = clienteServicio.getServicio().getId();
        nombreServicio = clienteServicio.getServicio().getNombre();
    }
    
    
    
}
