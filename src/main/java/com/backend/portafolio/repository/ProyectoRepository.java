package com.backend.portafolio.repository;

import com.backend.portafolio.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BlackJhossy
 */
@Repository
public interface ProyectoRepository  extends JpaRepository<Proyecto, Long>{
    
}
