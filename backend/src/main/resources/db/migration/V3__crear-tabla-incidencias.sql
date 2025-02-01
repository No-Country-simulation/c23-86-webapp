-- Crear tabla Incidencias
CREATE TABLE incidencias (
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_cliente BIGINT NOT NULL,
    id_servicio BIGINT NOT NULL,
    prioridad INT NOT NULL,
    estado VARCHAR(30) NOT NULL,
    fecha_de_alta DATE NOT NULL,
    descripcion TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id),
    FOREIGN KEY (id_servicio) REFERENCES servicios(id)
);

-- Crear tabla DetalleIncidencias
CREATE TABLE detalle_incidencias (
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_incidencia BIGINT NOT NULL,
    id_cliente BIGINT NOT NULL, 
    id_empleado BIGINT NOT NULL, -- Corrección: Cambié IN a INT
    fecha_de_modificacion DATE NOT NULL,
    descripcion TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_incidencia) REFERENCES incidencias(id),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);
