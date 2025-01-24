package com.callcenter.NoCountry.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="cliente_servicio")
public class ClienteServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Ingrese monto")
    private BigDecimal monto;
    @Column(name = "fecha_alta")
    @NotBlank(message = "Ingrese fecha del alta")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaAlta;
    
    @ManyToOne
    @JoinColumn( name = "id_servicio", nullable = false)
    private Servicios idServicio;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Clientes idCliente;
    
    @OneToMany(mappedBy = "clienteServicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HistorialPagos> historialPagos;

    
    public ClienteServicio(){
    }
    
    public ClienteServicio(BigDecimal monto, LocalDateTime fechaAlta, Servicios idServicio, Clientes idCliente){
        this.monto = monto;
        this.fechaAlta = fechaAlta;
        this.idServicio = idServicio;
        this.idCliente = idCliente;
    }
    
}
