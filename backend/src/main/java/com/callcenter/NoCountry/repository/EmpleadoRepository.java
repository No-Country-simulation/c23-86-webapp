package com.callcenter.NoCountry.repository;

import com.callcenter.NoCountry.entity.Empleados;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleados, Long>{
    Optional<Empleados> findByCorreoEmpresarial(String email);
}
