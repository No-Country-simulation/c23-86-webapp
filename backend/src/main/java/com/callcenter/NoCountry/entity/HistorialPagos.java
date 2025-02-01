package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "historial_de_pagos")
@Getter @Setter
@Data
public class HistorialPagos {
    @Id
    @Column(name = "id")
    private Long id_pago;
    private LocalDateTime fechaVencimiento;
    private LocalDateTime fechaPago;
    private BigDecimal montoPagado;
    @ManyToOne
    @JoinColumn(name = "id_cliente_servicio", nullable = false)
    private ClienteServicio clienteServicio;
}
