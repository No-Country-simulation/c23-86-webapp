-- Paso 1: Agregar las columnas estado y prioridad a la tabla detalle_de_incidencias
ALTER TABLE detalle_incidencias
ADD COLUMN estado VARCHAR(30) NOT NULL,
ADD COLUMN prioridad INT NOT NULL;

-- Paso 2: Insertar datos desde incidencias hacia detalle_de_incidencias, asignando id_Empleado = 1
INSERT INTO detalle_incidencias (id_incidencia, id_empleado, fecha_de_modificacion, descripcion, estado, prioridad)
SELECT
    i.id,
    1 AS id_empleado, -- Se asigna el valor 1 a id_Empleado
    i.fecha_de_alta AS fecha_de_modificacion, -- Usamos la fecha de alta como fecha inicial de modificación
    'Migración inicial de estado y prioridad' AS descripcion,
    i.estado,
    i.prioridad
FROM incidencias i;

-- Paso 3: Eliminar las columnas estado y prioridad de la tabla incidencias
ALTER TABLE incidencias
DROP COLUMN estado,
DROP COLUMN prioridad;
