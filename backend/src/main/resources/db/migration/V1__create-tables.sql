-- Tabla Empleados
CREATE TABLE empleados (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    rol VARCHAR(30) NOT NULL,
    correo_personal VARCHAR(50) NOT NULL,
    correo_empresarial VARCHAR(50) NOT NULL,
    clave VARCHAR(30) NOT NULL,
    telefono VARCHAR(30) NOT NULL,
    fecha_ingreso DATE NOT NULL,
    -- Campo para borrado lógico
    activo TINYINT NOT NULL DEFAULT 1
);

-- Tabla Clientes
CREATE TABLE clientes (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    dni BIGINT NOT NULL,  -- Cambiado a BIGINT para evitar problemas con DNIs largos
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    telefono VARCHAR(30) NOT NULL,
    estado VARCHAR(30) NOT NULL,
    -- Campo para borrado lógico
    activo TINYINT NOT NULL DEFAULT 1
);

-- Tabla Servicios
CREATE TABLE servicios (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

-- Tabla Cliente_Servicio
CREATE TABLE cliente_servicio (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_servicio INT NOT NULL,
    fecha_alta DATE NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id) ON DELETE CASCADE,
    FOREIGN KEY (id_servicio) REFERENCES servicios(id) ON DELETE CASCADE,
    UNIQUE (id_cliente, id_servicio, fecha_alta)
);

-- Tabla HistorialPagos referenciando la clave primaria subrogada
CREATE TABLE historial_de_pagos (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    fecha_pago DATE NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    monto_pagado DECIMAL(10,2) NOT NULL,
    id_cliente_servicio INT NOT NULL,
    FOREIGN KEY (id_cliente_servicio) REFERENCES cliente_servicio(id) ON DELETE CASCADE
);
