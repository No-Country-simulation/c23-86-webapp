package com.callcenter.NoCountry.DTO;

import com.callcenter.NoCountry.entity.HistorialPagos;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class HistorialPagoDTO {
    private LocalDateTime fechaPago;
    private LocalDateTime fechaVencimiento;
    private BigDecimal montoPagado;

    public HistorialPagoDTO(HistorialPagos pago) {
        this.fechaPago = pago.getFechaPago();
        this.fechaVencimiento = pago.getFechaVencimiento();
        this.montoPagado = pago.getMontoPagado();
    }
}
