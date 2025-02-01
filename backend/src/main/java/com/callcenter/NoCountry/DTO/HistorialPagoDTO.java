package com.callcenter.NoCountry.DTO;

import com.callcenter.NoCountry.entity.HistorialPagos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class HistorialPagoDTO {
    @JsonProperty("Fecha_de_pago")
    private LocalDateTime fechaPago;
    @JsonProperty("Fecha_de_vencimiento")
    private LocalDateTime fechaVencimiento;
    @JsonProperty("Monto_pagado")
    private BigDecimal montoPagado;

    public HistorialPagoDTO(HistorialPagos pago) {
        this.fechaPago = pago.getFechaPago();
        this.fechaVencimiento = pago.getFechaVencimiento();
        this.montoPagado = pago.getMontoPagado();
    }
}
