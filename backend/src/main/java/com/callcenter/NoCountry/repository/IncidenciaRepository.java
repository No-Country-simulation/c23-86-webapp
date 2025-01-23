package com.callcenter.NoCountry.repository;

import com.callcenter.NoCountry.entity.Incidencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencias, Long> {
    Optional<Object> findById(Integer id);
}
