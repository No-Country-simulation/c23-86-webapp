package com.callcenter.NoCountry.repository;

import com.callcenter.NoCountry.entity.DetalleIncidencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para gestionar las operaciones de acceso a datos
 * relacionadas con la entidad {@link DetalleIncidencias}.
 * Proporciona métodos para realizar operaciones CRUD y consultas personalizadas.
 */
@Repository
public interface DetalleIncidenciaRepository extends JpaRepository<DetalleIncidencias, Long> {

    /**
     * Recupera una lista de detalles de una incidencia específica.
     *
     * @param idIncidencia el identificador de la incidencia cuyos detalles se desean recuperar.
     * @return una lista de {@link DetalleIncidencias} asociadas a la incidencia especificada.
     */
    List<DetalleIncidencias> findByIncidencia_Id(Long idIncidencia);
    //List<DetalleIncidencias> findByCliente_id(Long id);
}

