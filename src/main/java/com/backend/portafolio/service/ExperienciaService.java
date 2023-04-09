package com.backend.portafolio.service;


import com.backend.portafolio.model.Experiencia;
import com.backend.portafolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BlackJhossy
 */
@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    public ExperienciaRepository expRepo;
    
    @Override
    public List<Experiencia> getExperiencias() {
        return expRepo.findAll();
    }

    @Override
    public Experiencia saveExperiencia(Experiencia user) {
        return expRepo.save(user);
    }

    @Override
    public void deleteExperiencia(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        return expRepo.findById(id).orElse(null);
    }
    
    @Override
    public Experiencia updateExperiencia(Experiencia exp){
        return expRepo.save(exp);
    }
}
