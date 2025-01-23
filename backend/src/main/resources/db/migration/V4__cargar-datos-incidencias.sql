-- Inserción de 3 registros aleatorios en la tabla Incidencias
INSERT INTO incidencias (id_Cliente, id_Servicio, prioridad, estado, fecha_de_alta, descripcion)
VALUES
    (1, 2, 1, 'Abierta', '2025-01-01', 'Primera incidencia de prueba'),
    (2, 1, 2, 'En Proceso', '2025-01-02', 'Segunda incidencia de prueba'),
    (3, 3, 3, 'Resuelta', '2025-01-03', 'Tercera incidencia de prueba');

-- Inserción de 3 registros aleatorios por cada incidencia en la tabla DetalleIncidencias
INSERT INTO detalle_de_incidencias (id_Incidencia, id_Empleado, fecha_de_modificacion, descripcion)
VALUES
    (1, 1, '2025-01-04', 'Detalle 1 para incidencia 1'),
    (1, 2, '2025-01-05', 'Detalle 2 para incidencia 1'),
    (1, 3, '2025-01-06', 'Detalle 3 para incidencia 1'),

    (2, 1, '2025-01-07', 'Detalle 1 para incidencia 2'),
    (2, 2, '2025-01-08', 'Detalle 2 para incidencia 2'),
    (2, 3, '2025-01-09', 'Detalle 3 para incidencia 2'),

    (3, 1, '2025-01-10', 'Detalle 1 para incidencia 3'),
    (3, 2, '2025-01-11', 'Detalle 2 para incidencia 3'),
    (3, 3, '2025-01-12', 'Detalle 3 para incidencia 3');
