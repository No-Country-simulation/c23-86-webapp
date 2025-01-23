-- Tabla Empleados
CREATE TABLE empleados (
    id_Empleado INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    rol VARCHAR(30) NOT NULL,
    correoPersonal VARCHAR(50) NOT NULL,
    correoEmpresarial VARCHAR(50) NOT NULL,
    clave VARCHAR(30) NOT NULL,
    telefono VARCHAR(30) NOT NULL,
    fechaIngreso DATE NOT NULL,
    -- Campo para borrado logico
    activo TINYINT NOT NULL DEFAULT 1,
    PRIMARY KEY (id_Empleado)
);

-- Tabla Clientes
CREATE TABLE clientes (
    id_Cliente INT NOT NULL AUTO_INCREMENT,
    dni INT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    telefono VARCHAR(30) NOT NULL,
    estado VARCHAR(30) NOT NULL,
    -- Campo para borrado logico
    activo TINYINT NOT NULL DEFAULT 1,
    PRIMARY KEY (id_Cliente)
);

-- Tabla Servicios
CREATE TABLE servicios (
    id_Servicio INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id_Servicio)
);

-- Tabla Cliente_Servicio
CREATE TABLE cliente_servicio (
    id_ClienteServicio INT NOT NULL AUTO_INCREMENT,
    id_Cliente INT NOT NULL,
    id_Servicio INT NOT NULL,
    fechaAlta DATE NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id_ClienteServicio),
    FOREIGN KEY (id_Cliente) REFERENCES clientes(id_Cliente),
    FOREIGN KEY (id_Servicio) REFERENCES servicios(id_Servicio),
    UNIQUE (id_Cliente, id_Servicio, fechaAlta)
);

-- Tabla HistorialPagos referenciando la clave primaria subrogada
CREATE TABLE historial_de_pagos (
    id_Pago INT NOT NULL AUTO_INCREMENT,
    fechaPago DATE NOT NULL,
    fechaVencimiento DATE NOT NULL,
    montoPagado DECIMAL(10,2) NOT NULL,
    id_ClienteServicio INT NOT NULL,
    PRIMARY KEY (id_Pago),
    FOREIGN KEY (id_ClienteServicio) REFERENCES cliente_servicio(id_ClienteServicio)
);
