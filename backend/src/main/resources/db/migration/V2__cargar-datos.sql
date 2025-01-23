-- Insertar datos en Empleados
INSERT INTO empleados (nombre, apellido, rol, correoPersonal, correoEmpresarial, clave, telefono, fechaIngreso)
VALUES
('Juan', 'Pérez', 'Administrador', 'juan.perez@gmail.com', 'jperez@empresa.com', 'clave123', 5523456789, '2023-01-10'),
('María', 'García', 'Telefonista', 'maria.garcia@gmail.com', 'mgarcia@empresa.com', 'clave456', 5529876543, '2022-05-15'),
('Luis', 'López', 'Supervisor', 'luis.lopez@gmail.com', 'llopez@empresa.com', 'clave789', 5521234567, '2023-06-20');

-- Insertar datos en Clientes
INSERT INTO clientes (dni, nombre, apellido, correo, telefono, estado)
VALUES
(123456, 'Ana', 'Martínez', 'ana.martinez@gmail.com', '5512345678', 'Activo'),
(789456, 'Carlos', 'Hernández', 'carlos.hernandez@gmail.com', '5598765432', 'Suspendido'),
(753694, 'Sofía', 'Rodríguez', 'sofia.rodriguez@gmail.com', '5587654321', 'De Baja');

-- Insertar datos en Servicios
INSERT INTO servicios (nombre, descripcion, precio)
VALUES
('Internet 100Mbps', 'Plan de internet de 100 Mbps', 499.99),
('Llamadas ilimitadas', 'Paquete de llamadas ilimitadas', 299.99),
('Streaming HD', 'Servicio de streaming en HD', 199.99);

-- Insertar datos en Cliente_Servicio
INSERT INTO cliente_servicio (id_Cliente, id_Servicio, monto, fechaAlta)
VALUES
(1, 1, 499.99, '2023-12-01'),
(1, 2, 299.99, '2023-12-05'),
(2, 3, 199.99, '2023-12-10'),
(3, 1, 499.99, '2023-12-15'),
(3, 2, 299.99, '2023-12-20'),
(3, 3, 199.99, '2023-12-25');

-- Insertar datos en HistorialPagos (3 pagos por cada cliente-servicio)
INSERT INTO historial_de_pagos (fechaPago, fechaVencimiento, montoPagado, id_ClienteServicio)
VALUES
-- Pagos del Cliente_Servicio correspondiente a Cliente 1 y Servicio 1
('2024-01-01', '2024-01-10', 499.99, 1),
('2024-01-15', '2024-01-25', 299.99, 2),
('2024-02-01', '2024-02-10', 499.99, 1),

-- Pagos del Cliente_Servicio correspondiente a Cliente 2 y Servicio 3
('2024-01-03', '2024-01-13', 199.99, 3),
('2024-01-20', '2024-01-30', 199.99, 3),
('2024-02-01', '2024-02-11', 199.99, 3),

-- Pagos del Cliente_Servicio correspondiente a Cliente 3 y varios servicios
('2024-01-05', '2024-01-15', 199.99, 6),
('2024-01-25', '2024-02-05', 499.99, 4),
('2024-02-10', '2024-02-20', 299.99, 5);
