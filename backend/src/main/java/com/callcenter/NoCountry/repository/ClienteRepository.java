package com.callcenter.NoCountry.repository;

import com.callcenter.NoCountry.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Clientes, Long> {
    Optional<Object> findById(Integer idCliente);
}
