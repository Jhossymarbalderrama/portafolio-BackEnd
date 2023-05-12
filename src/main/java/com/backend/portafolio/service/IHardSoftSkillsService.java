package com.backend.portafolio.service;

import com.backend.portafolio.model.HardSoftSkills;
import java.util.List;

/**
 *
 * @author BlackJhossy
 */
public interface IHardSoftSkillsService {
    public List<HardSoftSkills> getHSS();
    
    public HardSoftSkills findHSS (Long id);
    
    public HardSoftSkills saveHSS (HardSoftSkills hss);
    
    public void deleteHSS (Long id);
    
    public HardSoftSkills updateHSS (HardSoftSkills hss);
    
    public boolean existById(Long id);
}
