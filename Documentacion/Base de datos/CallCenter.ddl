-- Generado por Oracle SQL Developer Data Modeler 22.2.0.165.1149
--   en:        2025-01-17 20:40:38 ART
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE cliente (
    id_cliente NUMBER(7) NOT NULL,
    nombre     VARCHAR2(30 CHAR) NOT NULL,
    apellido   VARCHAR2(30 CHAR) NOT NULL,
    correo     VARCHAR2(50) NOT NULL,
    telefono   NUMBER(11) NOT NULL
);

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( id_cliente );

CREATE TABLE cliente_servicio (
    monto       NUMBER(10, 2) NOT NULL,
    fechaalta   DATE NOT NULL,
    id_servicio NUMBER NOT NULL,
    id_cliente  NUMBER(7) NOT NULL
);

ALTER TABLE cliente_servicio ADD CONSTRAINT idclienteservicio PRIMARY KEY ( id_cliente,
                                                                            id_servicio );

CREATE TABLE empleado (
    id_empleado       NUMBER(7) NOT NULL,
    nombre            VARCHAR2(30 CHAR) NOT NULL,
    apellido          VARCHAR2(30 CHAR) NOT NULL,
    rol               NUMBER(7) NOT NULL,
    correopersonal    VARCHAR2(50 CHAR) NOT NULL,
    correoempresarial VARCHAR2(50 CHAR) NOT NULL,
    clave             VARCHAR2(30 CHAR) NOT NULL,
    telefono          NUMBER(11),
    fechaingreso      DATE NOT NULL
);

ALTER TABLE empleado ADD CONSTRAINT empleado_pk PRIMARY KEY ( id_empleado );

CREATE TABLE historialpagos (
    id_pago          NUMBER(7) NOT NULL,
    fechapago        DATE,
    fechavencimiento DATE NOT NULL,
    montopagado      NUMBER(7, 2),
    id_cliente       NUMBER(7) NOT NULL,
    id_servicio      NUMBER(7) NOT NULL
);

CREATE INDEX historialpagos_indice ON
    historialpagos (
        id_pago
    ASC );

ALTER TABLE historialpagos ADD CONSTRAINT historialpagos_pk PRIMARY KEY ( id_pago );

CREATE TABLE incidencias (
    id_incidencia      NUMBER(7) NOT NULL,
    descripcion        VARCHAR2(250 CHAR) NOT NULL,
    prioridad          VARCHAR2(5 CHAR) NOT NULL,
    fechacreacion      DATE NOT NULL,
    fechaactualizacion DATE,
    tipoincidencia     VARCHAR2(30 CHAR) NOT NULL,
    id_empleado        NUMBER(7) NOT NULL,
    id_cliente         NUMBER(7) NOT NULL
);

ALTER TABLE incidencias ADD CONSTRAINT incidencias_pk PRIMARY KEY ( id_incidencia );

CREATE TABLE roles (
    id_rol      NUMBER(7) NOT NULL,
    nombre      VARCHAR2(30 CHAR) NOT NULL,
    descripcion VARCHAR2(200 CHAR) NOT NULL
);

ALTER TABLE roles ADD CONSTRAINT roles_pk PRIMARY KEY ( id_rol );

CREATE TABLE servicios (
    id_servicio NUMBER NOT NULL,
    nombre      VARCHAR2(30 CHAR) NOT NULL,
    descripcion VARCHAR2(200 CHAR),
    precio      NUMBER(10, 2) NOT NULL
);

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( id_servicio );

ALTER TABLE cliente_servicio
    ADD CONSTRAINT cliente_fk FOREIGN KEY ( id_cliente )
        REFERENCES cliente ( id_cliente );

ALTER TABLE historialpagos
    ADD CONSTRAINT cliente_servicio_fk FOREIGN KEY ( id_cliente,
                                                     id_servicio )
        REFERENCES cliente_servicio ( id_cliente,
                                      id_servicio );

ALTER TABLE incidencias
    ADD CONSTRAINT incidencias_cliente_fk FOREIGN KEY ( id_cliente )
        REFERENCES cliente ( id_cliente );

ALTER TABLE incidencias
    ADD CONSTRAINT incidencias_empleado_fk FOREIGN KEY ( id_empleado )
        REFERENCES empleado ( id_empleado );

ALTER TABLE empleado
    ADD CONSTRAINT rol_fk FOREIGN KEY ( rol )
        REFERENCES roles ( id_rol );

ALTER TABLE cliente_servicio
    ADD CONSTRAINT servicio_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             1
-- ALTER TABLE                             13
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
