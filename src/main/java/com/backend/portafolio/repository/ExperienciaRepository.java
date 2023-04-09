
package com.backend.portafolio.repository;

import com.backend.portafolio.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BlackJhossy
 */
@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia,Long>{
    
}
