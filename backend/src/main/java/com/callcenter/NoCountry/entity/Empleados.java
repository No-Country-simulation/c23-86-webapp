package com.callcenter.NoCountry.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Empleados extends Usuarios{
    @NotBlank(message = "ingresar rol")
    private String rol;
    @NotBlank(message = "ingresar correo empresarial")
    private String correoEmpresarial;
    @NotBlank(message = "ingresar contraseña")
    private String contraseña;
    private Long supervisor;

    public Empleados(String nombre, String apellido, String correo, String telefono, LocalDateTime fechaAlta, LocalDateTime fechaBaja, String rol, String correoEmpresarial, String contraseña, Long supervisor) {
        super(nombre, apellido, correo, telefono, fechaAlta, fechaBaja);
        this.rol = rol;
        this.correoEmpresarial = correoEmpresarial;
        this.contraseña = contraseña;
        this.supervisor = supervisor;
    }
}
