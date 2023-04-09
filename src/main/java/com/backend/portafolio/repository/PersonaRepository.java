package com.backend.portafolio.repository;

import com.backend.portafolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BlackJhossy
 */

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}
