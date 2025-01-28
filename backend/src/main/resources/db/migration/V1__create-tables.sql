-- Tabla Empleados
CREATE TABLE empleados (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    rol VARCHAR(30) NOT NULL,
    correo_personal VARCHAR(50) NOT NULL,
    correo_empresarial VARCHAR(50) NOT NULL,
    clave VARCHAR(30) NOT NULL,
    telefono VARCHAR(30) NOT NULL,
    fecha_ingreso DATE NOT NULL,
    -- Campo para borrado logico
    activo TINYINT NOT NULL DEFAULT 1,
    PRIMARY KEY (id)
);

-- Tabla Clientes
CREATE TABLE clientes (
    id INT NOT NULL AUTO_INCREMENT,
    dni INT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    telefono VARCHAR(30) NOT NULL,
    estado VARCHAR(30) NOT NULL,
    -- Campo para borrado logico
    activo TINYINT NOT NULL DEFAULT 1,
    PRIMARY KEY (id)
);

-- Tabla Servicios
CREATE TABLE servicios (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id)
);

-- Tabla Cliente_Servicio
CREATE TABLE cliente_servicio (
    id INT NOT NULL AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    id_servicio INT NOT NULL,
    fecha_alta DATE NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id),
    FOREIGN KEY (id_servicio) REFERENCES servicios(id),
    UNIQUE (id_cliente, id_servicio, fecha_alta)
);

-- Tabla HistorialPagos referenciando la clave primaria subrogada
CREATE TABLE historial_de_pagos (
    id INT NOT NULL AUTO_INCREMENT,
    fecha_pago DATE NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    monto_pagado DECIMAL(10,2) NOT NULL,
    id_cliente_servicio INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente_servicio) REFERENCES cliente_servicio(id)
);
