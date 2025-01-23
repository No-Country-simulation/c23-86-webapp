-- Crear tabla Incidencias
CREATE TABLE incidencias (
    id_Incidencia INT NOT NULL AUTO_INCREMENT,
    id_Cliente INT NOT NULL,
    id_Servicio INT NOT NULL,
    prioridad INT NOT NULL,
    estado VARCHAR(30) NOT NULL,
    fecha_de_alta DATE NOT NULL,
    descripcion TEXT NOT NULL,
    PRIMARY KEY (id_Incidencia),
    FOREIGN KEY (id_Cliente) REFERENCES clientes(id_Cliente),
    FOREIGN KEY (id_Servicio) REFERENCES servicios(id_Servicio)
);

-- Crear tabla DetalleIncidencias
CREATE TABLE detalle_de_incidencias (
    id_Detalle INT NOT NULL AUTO_INCREMENT,
    id_Incidencia INT NOT NULL,
    id_Empleado INT NOT NULL,
    fecha_de_modificacion DATE NOT NULL,
    descripcion TEXT NOT NULL,
    PRIMARY KEY (id_Detalle),
    FOREIGN KEY (id_Incidencia) REFERENCES incidencias(id_Incidencia),
    FOREIGN KEY (id_Empleado) REFERENCES empleados(id_Empleado)
);
