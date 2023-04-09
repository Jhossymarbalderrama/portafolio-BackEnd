/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    //Listar Todas las personas
    @Override
    public List<Persona> getPersonas(){
        return persoRepo.findAll();
    }
    
    //Muestro a una persona x ID
    @Override
    public Persona findPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }
    
    //Guardo doy de Alta a una Persona
    @Override
    public Persona savePersona(Persona per) {
        return persoRepo.save(per);
    }

    //Elimino doy de Baja a una Persona
    @Override
    public void deletePersona(Long id) {    
        persoRepo.deleteById(id);        
    }
    
    @Override
    public Persona updatePersona(Persona persona){
        return persoRepo.save(persona);
    }
    
}
