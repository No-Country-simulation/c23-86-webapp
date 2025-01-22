package com.callcenter.NoCountry.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class ClienteServicioId implements Serializable{
    
    private LocalDateTime fechaAlta;
    @ManyToOne
    @JoinColumn( name = "id_Servicio", nullable = false)
    private Servicios id_Servicio;
    @ManyToOne
    @JoinColumn(name = "id_Cliente", nullable = false)
    private Clientes id_cliente;
    
    @Override
    public int hashCode(){
        return Objects.hash(id_cliente, id_Servicio, fechaAlta);
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        ClienteServicioId that = (ClienteServicioId) obj;
        return Objects.equals(this.getId_cliente(), that.getId_cliente()) &&
               Objects.equals(this.getId_Servicio(), that.getId_Servicio()) &&
               Objects.equals(this.fechaAlta, that.getFechaAlta());
    }
}
