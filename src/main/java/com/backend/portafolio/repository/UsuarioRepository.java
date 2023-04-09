
package com.backend.portafolio.repository;

import com.backend.portafolio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BlackJhossy
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
