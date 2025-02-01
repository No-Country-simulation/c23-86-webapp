
package com.callcenter.NoCountry.repository;

import com.callcenter.NoCountry.entity.ClienteServicio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteServicioRepository extends JpaRepository<ClienteServicio, Long>{
    List<ClienteServicio> findByCliente_id(Long id); 
}
