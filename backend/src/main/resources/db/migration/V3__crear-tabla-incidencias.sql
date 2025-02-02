-- Crear tabla Incidencias
CREATE TABLE incidencias (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_servicio INT NOT NULL,
    fecha_de_alta TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    descripcion TEXT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id) ON DELETE CASCADE,
    FOREIGN KEY (id_servicio) REFERENCES servicios(id) ON DELETE CASCADE
);

-- Crear tabla DetalleIncidencias
CREATE TABLE detalle_de_incidencias (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_incidencia INT NOT NULL,
    id_empleado INT NOT NULL,
    prioridad INT NOT NULL,
    estado VARCHAR(30) NOT NULL,
    fecha_de_modificacion TIMESTAMP NOT NULL,
    descripcion TEXT NOT NULL,
    FOREIGN KEY (id_incidencia) REFERENCES incidencias(id) ON DELETE CASCADE,
    FOREIGN KEY (id_empleado) REFERENCES empleados(id) ON DELETE SET NULL
);
