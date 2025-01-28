package com.callcenter.NoCountry.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "historial_de_pagos")
@Getter @Setter
public class HistorialPagos {
    @Id
    @Column(name = "id")
    private Long id_pago;
    private LocalDateTime fechaVencimiento;
    private Float montoPagado;
    @ManyToOne
    @JoinColumn(name = "id_cliente_servicio", nullable = false)
    private ClienteServicio clienteServicio;


}
