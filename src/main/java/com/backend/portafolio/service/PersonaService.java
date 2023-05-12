package com.backend.portafolio.service;

import com.backend.portafolio.model.Persona;
import com.backend.portafolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author BlackJhossy
 */
@Service
public class PersonaService implements IPersonaService{
   
    @Autowired
    public PersonaRepository persoRepo;
    
    @Override
    public List<Persona> getPersonas(){
        return persoRepo.findAll();
    }
    
    @Override
    public Persona findPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }
    
    @Override
    public Persona savePersona(Persona per) {
        return persoRepo.save(per);
    }

    @Override
    public void deletePersona(Long id) {    
        persoRepo.deleteById(id);        
    }
    
    @Override
    public Persona updatePersona(Persona persona){
        return persoRepo.save(persona);
    }
    
    @Override
    public boolean existById(Long id){
        return persoRepo.existsById(id);
    }  
}
