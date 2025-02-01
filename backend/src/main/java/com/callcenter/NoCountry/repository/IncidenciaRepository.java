package com.callcenter.NoCountry.repository;

import com.callcenter.NoCountry.entity.Incidencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para gestionar las operaciones de acceso a datos
 * relacionadas con la entidad {@link Incidencias}.
 * Proporciona métodos para realizar operaciones CRUD y consultas personalizadas.
 */
@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencias, Long> {

    /**
     * Recupera una incidencia específica según su identificador.
     *
     * @param id el identificador único de la incidencia.
     * @return un {@link Optional} que contiene la incidencia si se encuentra, o vacío si no existe.
     */
    Optional<Object> findById(Integer id);
    List<Incidencias> findByClienteId(Long clienteId);
}
