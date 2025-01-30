-- Insertar datos en Roles
INSERT INTO Roles (nombre, descripcion)
VALUES
('Administrador', 'Encargado de la administración general'),
('Telefonista', 'Encargado de resolver incidencias'),
('Supervisor', 'Encargado del equipo de telefonistas');

-- Insertar datos en Empleados
INSERT INTO Empleados (nombre, apellido, rol, correoPersonal, correoEmpresarial, clave, telefono, fechaIngreso)
VALUES
('Juan', 'Pérez', 1, 'juan.perez@gmail.com', 'jperez@empresa.com', 'clave123', 5523456789, '2023-01-10'),
('María', 'García', 2, 'maria.garcia@gmail.com', 'mgarcia@empresa.com', 'clave456', 5529876543, '2022-05-15'),
('Luis', 'López', 3, 'luis.lopez@gmail.com', 'llopez@empresa.com', 'clave789', 5521234567, '2023-06-20');

-- Insertar datos en Clientes
INSERT INTO Clientes (nombre, apellido, correo, telefono, estado)
VALUES
('Ana', 'Martínez', 'ana.martinez@gmail.com', 5512345678, 'Activo'),
('Carlos', 'Hernández', 'carlos.hernandez@gmail.com', 5598765432, 'Suspendido'),
('Sofía', 'Rodríguez', 'sofia.rodriguez@gmail.com', 5587654321, 'De Baja');

-- Insertar datos en Servicios
INSERT INTO Servicios (nombre, descripcion, precio)
VALUES
('Internet 100Mbps', 'Plan de internet de 100 Mbps', 499.99),
('Llamadas ilimitadas', 'Paquete de llamadas ilimitadas', 299.99),
('Streaming HD', 'Servicio de streaming en HD', 199.99);

-- Insertar datos en Incidencias
INSERT INTO Incidencias (descripcion, prioridad, fechaCreacion, fechaActualizacion, tipoIncidencia, id_Empleado, id_Cliente)
VALUES
('Internet no funciona', 'Alta', '2024-01-10', '2024-01-11', 'Técnico', 2, 1),
('No puedo acceder a mi cuenta', 'Media', '2024-01-12', '2024-01-13', 'Cuenta', 2, 2),
('Problemas con la facturación', 'Baja', '2024-01-14', '2024-01-14', 'Administrativo', 1, 1);


-- Insertar datos en Cliente_Servicio para asegurarnos de que las combinaciones existen
INSERT INTO Cliente_Servicio (id_Cliente, id_Servicio, monto, fechaAlta)
VALUES
(1, 1, 499.99, '2023-12-01'),
(1, 2, 299.99, '2023-12-05'),
(2, 3, 199.99, '2023-12-10'),
(3, 1, 499.99, '2023-12-15'),
(3, 2, 299.99, '2023-12-20'),
(3, 3, 199.99, '2023-12-25');

-- Insertar datos en HistorialPagos (3 pagos por cada cliente)
INSERT INTO HistorialPagos (fechaPago, fechaVencimiento, montoPagado, id_cliente, id_servicio)
VALUES
-- Pagos del Cliente 1
('2024-01-01', '2024-01-10', 499.99, 1, 1),
('2024-01-15', '2024-01-25', 299.99, 1, 2),
('2024-02-01', '2024-02-10', 499.99, 1, 1),

-- Pagos del Cliente 2
('2024-01-03', '2024-01-13', 199.99, 2, 3),
('2024-01-20', '2024-01-30', 199.99, 2, 3),
('2024-02-01', '2024-02-11', 199.99, 2, 3),

-- Pagos del Cliente 3
('2024-01-05', '2024-01-15', 199.99, 3, 3),
('2024-01-25', '2024-02-05', 499.99, 3, 1),
('2024-02-10', '2024-02-20', 299.99, 3, 2);