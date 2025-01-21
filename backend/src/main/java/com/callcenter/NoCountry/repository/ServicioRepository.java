package com.callcenter.NoCountry.repository;

import com.callcenter.NoCountry.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    Optional<Object> findById(Integer idServicio);
}
