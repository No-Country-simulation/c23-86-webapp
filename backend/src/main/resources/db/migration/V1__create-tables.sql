-- Tabla Roles
CREATE TABLE Roles (
    id_Rol INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    PRIMARY KEY (id_Rol)
);

-- Tabla Empleados
CREATE TABLE Empleados (
    id_Empleado INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    rol INT NOT NULL,
    correoPersonal VARCHAR(50) NOT NULL,
    correoEmpresarial VARCHAR(50) NOT NULL,
    clave VARCHAR(30) NOT NULL,
    telefono VARCHAR(30) NOT NULL,
    fechaIngreso DATE NOT NULL,
    -- Campo para borrado logico
    activo TINYINT NOT NULL DEFAULT 1,
    PRIMARY KEY (id_Empleado),
    FOREIGN KEY (rol) REFERENCES Roles(id_Rol)
);

-- Tabla Clientes
CREATE TABLE Clientes (
    id_Cliente INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    telefono BIGINT NOT NULL,
    estado VARCHAR(30) NOT NULL,
    -- Campo para borrado logico
    activo TINYINT NOT NULL DEFAULT 1,
    PRIMARY KEY (id_Cliente)
);

-- Tabla Servicios
CREATE TABLE Servicios (
    id_Servicio INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id_Servicio)
);

-- Tabla Cliente_Servicio
CREATE TABLE Cliente_Servicio (
    id_Cliente INT NOT NULL,
    id_Servicio INT NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    fechaAlta DATE NOT NULL,
    PRIMARY KEY (id_Cliente, id_Servicio),
    FOREIGN KEY (id_Cliente) REFERENCES Clientes(id_Cliente),
    FOREIGN KEY (id_Servicio) REFERENCES Servicios(id_Servicio)
);

-- Tabla Incidencias
CREATE TABLE Incidencias (
    id_incidencia INT NOT NULL AUTO_INCREMENT,
    descripcion TEXT NOT NULL,
    prioridad VARCHAR(5) NOT NULL,
    fechaCreacion DATE NOT NULL,
    fechaActualizacion DATE NOT NULL,
    tipoIncidencia VARCHAR(30) NOT NULL,
    id_Empleado INT NOT NULL,
    id_Cliente INT NOT NULL,
    PRIMARY KEY (id_incidencia),
    FOREIGN KEY (id_Empleado) REFERENCES Empleados(id_Empleado),
    FOREIGN KEY (id_Cliente) REFERENCES Clientes(id_Cliente)
);

-- Tabla HistorialPagos
CREATE TABLE HistorialPagos (
    id_Pago INT NOT NULL AUTO_INCREMENT,
    fechaPago DATE NOT NULL,
    fechaVencimiento DATE NOT NULL,
    montoPagado DECIMAL(10,2) NOT NULL,
    id_cliente INT NOT NULL,
    id_servicio INT NOT NULL,
    PRIMARY KEY (id_Pago),
    FOREIGN KEY (id_cliente, id_servicio) REFERENCES Cliente_Servicio(id_Cliente, id_Servicio)
);
