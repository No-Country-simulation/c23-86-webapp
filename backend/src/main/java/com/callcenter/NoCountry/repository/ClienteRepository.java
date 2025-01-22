package com.callcenter.NoCountry.repository;

import com.callcenter.NoCountry.entity.Clientes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {
    Optional<Object> findById(Integer idCliente);
    List<Clientes> findByDni(Long dni);
    List<Clientes> findByNombreContainingIgnoreCase(String nombre);
    List<Clientes> findByApellidoContainingIgnoreCase(String apellido);
}
