package com.backend.portafolio.service;

import com.backend.portafolio.model.Proyecto;
import java.util.List;

/**
 *
 * @author BlackJhossy
 */
public interface IProyectoService {
    public List<Proyecto> getProyectos();
    
    public Proyecto findProyecto (Long id);
    
    public Proyecto saveProyecto (Proyecto proyect);
    
    public void deleteProyecto (Long id);

    public Proyecto updateProyecto (Proyecto proyect);
}
