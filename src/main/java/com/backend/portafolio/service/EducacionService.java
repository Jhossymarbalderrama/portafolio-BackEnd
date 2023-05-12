
package com.backend.portafolio.service;


import com.backend.portafolio.model.Educacion;
import com.backend.portafolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BlackJhossy
 */
@Service
public class EducacionService implements IEducacionService{
    @Autowired
    public EducacionRepository eduRep;
    
    @Override
    public List<Educacion> getEducaciones() {
        return eduRep.findAll();
    }

    @Override
    public Educacion saveEducacion(Educacion user) {
        return eduRep.save(user);
    }

    @Override
    public void deleteEducacion(Long id) {
        eduRep.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        return eduRep.findById(id).orElse(null);
    }
    
    @Override 
    public Educacion updateEducacion(Educacion edu){
        return eduRep.save(edu);
    }
    
    @Override
    public boolean existById(Long id){
        return eduRep.existsById(id);
    }
}
