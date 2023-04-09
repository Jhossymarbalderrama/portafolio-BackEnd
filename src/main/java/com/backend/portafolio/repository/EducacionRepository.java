
package com.backend.portafolio.repository;

import com.backend.portafolio.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BlackJhossy
 */
@Repository
public interface EducacionRepository extends JpaRepository<Educacion,Long>{
    
}
