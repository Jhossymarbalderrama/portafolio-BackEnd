package com.backend.portafolio.repository;

import com.backend.portafolio.model.RedesSociales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BlackJhossy
 */
@Repository
public interface RedesSocialesRepository extends JpaRepository<RedesSociales, Long> {
    
}
