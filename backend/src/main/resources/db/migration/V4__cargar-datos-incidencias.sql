-- Inserción de 3 registros en la tabla Incidencias
INSERT INTO incidencias (id_cliente, id_servicio, fecha_de_alta, descripcion)
VALUES
    (1, 2, '2025-01-01', 'Primera incidencia de prueba'),
    (2, 1, '2025-01-02', 'Segunda incidencia de prueba'),
    (3, 3, '2025-01-03', 'Tercera incidencia de prueba');

-- Inserción de 3 registros en la tabla DetalleIncidencias por cada incidencia
INSERT INTO detalle_de_incidencias (id_incidencia, id_empleado, prioridad, estado, fecha_de_modificacion, descripcion)
VALUES
    (1, 1, 1, 'Abierto', '2025-01-04', 'Detalle 1 para incidencia 1'),
    (1, 2, 2, 'En Progreso', '2025-01-05', 'Detalle 2 para incidencia 1'),
    (1, 3, 3, 'Cerrado', '2025-01-06', 'Detalle 3 para incidencia 1'),

    (2, 1, 1, 'Abierto', '2025-01-07', 'Detalle 1 para incidencia 2'),
    (2, 2, 2, 'En Progreso', '2025-01-08', 'Detalle 2 para incidencia 2'),
    (2, 3, 3, 'Cerrado', '2025-01-09', 'Detalle 3 para incidencia 2'),

    (3, 1, 1, 'Abierto', '2025-01-10', 'Detalle 1 para incidencia 3'),
    (3, 2, 2, 'En Progreso', '2025-01-11', 'Detalle 2 para incidencia 3'),
    (3, 3, 3, 'Cerrado', '2025-01-12', 'Detalle 3 para incidencia 3');
