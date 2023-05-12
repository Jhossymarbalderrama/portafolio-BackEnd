package com.backend.portafolio.service;


import com.backend.portafolio.model.Experiencia;
import java.util.List;

/**
 *
 * @author BlackJhossy
 */
public interface IExperienciaService {
   public List<Experiencia> getExperiencias();
    
   public Experiencia findExperiencia (Long id); 
   
    public Experiencia saveExperiencia (Experiencia exp);
    
    public void deleteExperiencia (Long id);
    
    public Experiencia updateExperiencia(Experiencia exp);
    
    public boolean existById(Long id);
}
