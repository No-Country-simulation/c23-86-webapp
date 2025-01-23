package com.callcenter.NoCountry.repository;

import com.callcenter.NoCountry.entity.DetalleIncidencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleIncidenciaRepository extends JpaRepository<DetalleIncidencias, Long> {
    List<DetalleIncidencias> findByIncidenciaId(Long idIncidencia);
}
