package com.backend.portafolio.service;

import com.backend.portafolio.model.Educacion;
import java.util.List;

/**
 *
 * @author BlackJhossy
 */
public interface IEducacionService {
    public List<Educacion> getEducaciones();
    
    public Educacion findEducacion (Long id);
    
    public Educacion saveEducacion (Educacion edu);
    
    public void deleteEducacion (Long id);
        
    public Educacion updateEducacion(Educacion edu);
    
    public boolean existById(Long id);
}
