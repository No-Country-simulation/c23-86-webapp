package com.callcenter.NoCountry.repository;

import com.callcenter.NoCountry.entity.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicios, Long> {
    Optional<Object> findById(Integer idServicio);
}
