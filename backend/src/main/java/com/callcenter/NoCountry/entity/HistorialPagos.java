package com.callcenter.NoCountry.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "historial_pagos")
public class HistorialPagos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "fecha_pago", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaPago;
    
    @Column(name = "fecha_vencimiento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaVencimiento;
    
    @Column(name = "monto_pagado", nullable = false)
    private BigDecimal montoPagado;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente_servicio", nullable = false)
    private ClienteServicio clienteServicio;
    
    public HistorialPagos(){
    }
    
    public HistorialPagos(LocalDateTime fechaPago, LocalDateTime fechaVencimiento, BigDecimal montoPagado, ClienteServicio clienteServicio){
        this.fechaPago = fechaPago;
        this.fechaVencimiento = fechaVencimiento;
        this.montoPagado = montoPagado;
        this.clienteServicio = clienteServicio;
    }
}
