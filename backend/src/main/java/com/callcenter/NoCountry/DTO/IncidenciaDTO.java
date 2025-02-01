package com.callcenter.NoCountry.DTO;

import com.callcenter.NoCountry.entity.Incidencias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) para representar una incidencia y sus detalles asociados.
 * Esta clase sirve para transferir información de la entidad {@link Incidencias} al cliente.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncidenciaDTO extends IncidenciaSinDatosClienteDTO {
    private Long idCliente;
    private ClienteDTO cliente;

    public IncidenciaDTO(Incidencias incidencia) {
        super(incidencia);
        this.idCliente = incidencia.getCliente().getId();
        this.cliente = new ClienteDTO(incidencia.getCliente());
    }
}

