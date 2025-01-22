package com.callcenter.NoCountry.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class HistorialPagos {
    private Long id_pago;
    private LocalDateTime fechaVencimiento;
    private Float montoPagado;
    
    private Clientes id_Cliente;
    private Servicios id_Servicios;
    private LocalDateTime fechaAlta;
    
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "id_Cliente", referencedColumnName = "id_cliente", nullable = false),
        @JoinColumn(name = "id_Servicios", referencedColumnName = "id_Servicios", nullable = false),
        @JoinColumn(name = "fechaAlta", referencedColumnName = "fechaAlta", nullable = false)
    })
    private ClienteServicio clienteServiciId;
}
