package com.backend.portafolio.repository;

import com.backend.portafolio.model.HardSoftSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BlackJhossy
 */
@Repository
public interface HardSoftSkillsRepository extends JpaRepository<HardSoftSkills, Long>{
    
}
