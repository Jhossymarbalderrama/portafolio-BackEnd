
package com.backend.portafolio.service;

import com.backend.portafolio.model.HardSoftSkills;
import com.backend.portafolio.repository.HardSoftSkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BlackJhossy
 */
@Service
public class HardSoftSkillsService implements IHardSoftSkillsService{
    
    @Autowired
    public HardSoftSkillsRepository hssRepo;
    
    @Override
    public List<HardSoftSkills> getHSS(){
        return hssRepo.findAll();
    }
    
    @Override
    public HardSoftSkills saveHSS(HardSoftSkills hss) {
        return hssRepo.save(hss);
    }
    
    @Override
    public void deleteHSS(Long id) {
        hssRepo.deleteById(id);
    }
    
    @Override
    public HardSoftSkills findHSS(Long id) {
        return hssRepo.findById(id).orElse(null);
    }
    
    @Override
    public HardSoftSkills updateHSS(HardSoftSkills hss){
        return hssRepo.save(hss);
    }
    
    @Override
    public boolean existById(Long id){
        return hssRepo.existsById(id);
    } 
}
