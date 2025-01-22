package com.callcenter.NoCountry.entity;

import jakarta.persistence.EmbeddedId;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ClienteServicio {
    @EmbeddedId
    private ClienteServicioId id;
    private BigDecimal monto;
    
}
