package com.backend.portafolio.service;

import com.backend.portafolio.model.Persona;
import java.util.List;

/**
 *
 * @author BlackJhossy
 */
public interface IPersonaService {
    
    public List<Persona> getPersonas();
    
    public Persona findPersona (Long id);    
    
    public Persona savePersona (Persona per);
    
    public void deletePersona (Long id);
    
    public Persona updatePersona(Persona persona);
    
    public boolean existById(Long id);
}
