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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cliente_servicio")
@Getter @Setter
public class ClienteServicio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;
    
    @Column(name = "fecha_alta", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaAlta;
    
    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false)
    private Servicios servicio;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Clientes cliente;
    
    @OneToMany(mappedBy = "clienteServicio", cascade = CascadeType.ALL)
    private Set<HistorialPagos> historialPagos;

    
    public ClienteServicio(){
    }
    
    public ClienteServicio(BigDecimal monto, LocalDateTime fechaAlta, Servicios servicio, Clientes cliente){
        this.monto = monto;
        this.fechaAlta = fechaAlta;
        this.servicio = servicio;
        this.cliente = cliente;
    }
}
