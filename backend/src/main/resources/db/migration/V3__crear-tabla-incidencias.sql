-- Crear tabla Incidencias
CREATE TABLE incidencias (
    id INT NOT NULL AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    id_servicio INT NOT NULL,
    prioridad INT NOT NULL,
    estado VARCHAR(30) NOT NULL,
    fecha_de_alta DATE NOT NULL,
    descripcion TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id),
    FOREIGN KEY (id_servicio) REFERENCES servicios(id)
);

-- Crear tabla DetalleIncidencias
CREATE TABLE detalle_de_incidencias (
    id INT NOT NULL AUTO_INCREMENT,
    id_incidencia INT NOT NULL,
    id_empleado INT NOT NULL,
    fecha_de_modificacion DATE NOT NULL,
    descripcion TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_incidencia) REFERENCES incidencias(id),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id)
);
