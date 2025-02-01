package com.callcenter.NoCountry.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empleados")
public class Empleados extends Usuarios{
    
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "ingresar rol")
    @Column(name = "rol")
    private Rol rol;
    
    @NotBlank(message = "ingresar correo empresarial")
    @Column(name = "correo_empresarial")
    private String correoEmpresarial;
    
    @NotBlank(message = "ingresar contraseña")
    @Column(name = "clave")
    private String clave;
    
    @ManyToOne
    @JoinColumn(name = "id_supervisor")
    private Empleados supervisor;
    
    @OneToMany(mappedBy = "supervisor")
    private Set<Empleados> empleadosSupervisados;
    
    @OneToMany(mappedBy = "empleado")
    private List<DetalleIncidencias> detalleIncidencias;
    
    public Empleados(Long dni,String nombre, String apellido, String correo, String telefono, Rol rol, String correoEmpresarial, String clave) {
        super(dni, nombre, apellido, correo, telefono);
        this.rol = rol;
        this.correoEmpresarial = correoEmpresarial;
        this.clave = clave;
    }
}