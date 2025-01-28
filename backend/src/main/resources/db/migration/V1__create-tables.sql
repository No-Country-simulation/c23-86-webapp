-- Tabla Empleados
CREATE TABLE empleados (
    id BIGINT NOT NULL AUTO_INCREMENT,
    dni BIGINT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    rol VARCHAR(30) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    correo_empresarial VARCHAR(50) NOT NULL,
    clave VARCHAR(30) NOT NULL,
    telefono VARCHAR(30) NOT NULL,
    id_supervisor BIGINT,
    -- Campo para borrado logico
    activo TINYINT NOT NULL DEFAULT 1,
    PRIMARY KEY (id),
    FOREIGN KEY(id_supervisor) REFERENCES empleados(id)
);

-- Tabla Clientes
CREATE TABLE clientes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    dni BIGINT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    telefono VARCHAR(30) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    estado VARCHAR(30) NOT NULL,
    -- Campo para borrado logico
    activo TINYINT NOT NULL DEFAULT 1,
    PRIMARY KEY (id)
);

-- Tabla Servicios
CREATE TABLE servicios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id)
);

-- Tabla cliente_servicio
CREATE TABLE cliente_servicio (
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_cliente BIGINT NOT NULL,
    id_servicio BIGINT NOT NULL,
    fecha_alta DATE NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id),
    FOREIGN KEY (id_servicio) REFERENCES servicios(id),
    UNIQUE (id_cliente, id_servicio, fecha_alta)
);

-- Tabla HistorialPagos referenciando la clave primaria subrogada
CREATE TABLE historial_pagos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    fecha_pago DATE NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    monto_pagado DECIMAL(10,2) NOT NULL,
    id_cliente_servicio BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente_servicio) REFERENCES cliente_servicio(id)
);

