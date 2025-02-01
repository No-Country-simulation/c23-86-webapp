package com.callcenter.NoCountry.DTO;

import com.callcenter.NoCountry.entity.Clientes;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ClienteCompletoDTO {
    private ClienteDTO clienteDTO;
    private List<IncidenciaSinDatosClienteDTO> incidenciaDTOS;
    private List<ServicioDTO> servicioDTOS;

    public ClienteCompletoDTO(Clientes clientes) {
        this.clienteDTO = new ClienteDTO(clientes);
        this.incidenciaDTOS = clientes.getIncidencias().stream()
                .map(IncidenciaSinDatosClienteDTO::new)
                .collect(Collectors.toList());
        //mapear servicios
        this.servicioDTOS = clientes.getServicios().stream()
                .map(clienteServicio -> new ServicioDTO(
                        clienteServicio.getServicio().getNombre(),
                        clienteServicio.getServicio().getDescripcion(),
                        clienteServicio.getServicio().getPrecio(),
                        clienteServicio.getFechaAlta(),
                        clienteServicio.getMonto(),
                        clienteServicio.getHistorialPagos().stream()
                                .map(pago -> new HistorialPagoDTO(
                                        pago.getFechaPago(),
                                        pago.getFechaVencimiento(),
                                        pago.getMontoPagado()
                                ))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}
