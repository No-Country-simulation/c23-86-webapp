-- Crear tabla Incidencias
CREATE TABLE Incidencias (
    id_Incidencia INT NOT NULL AUTO_INCREMENT,
    id_Cliente INT NOT NULL,
    id_Servicio INT NOT NULL,
    prioridad INT NOT NULL,
    estado VARCHAR(30) NOT NULL,
    fechaDeAlta DATE NOT NULL,
    descripcion TEXT NOT NULL,
    PRIMARY KEY (id_Incidencia),
    FOREIGN KEY (id_Cliente) REFERENCES Clientes(id_Cliente),
    FOREIGN KEY (id_Servicio) REFERENCES Servicios(id_Servicio)
);

-- Crear tabla DetalleIncidencias
CREATE TABLE DetalleIncidencias (
    id_Detalle INT NOT NULL AUTO_INCREMENT,
    id_Incidencia INT NOT NULL,
    id_Empleado INT NOT NULL, -- Corrección: Cambié IN a INT
    fechaDeModificacion DATE NOT NULL,
    descripcion TEXT NOT NULL,
    PRIMARY KEY (id_Detalle),
    FOREIGN KEY (id_Incidencia) REFERENCES Incidencias(id_Incidencia),
    FOREIGN KEY (id_Empleado) REFERENCES Empleados(id_Empleado)
);
