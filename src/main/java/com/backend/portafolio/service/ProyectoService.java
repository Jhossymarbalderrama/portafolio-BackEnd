
package com.backend.portafolio.service;

import com.backend.portafolio.model.Proyecto;
import com.backend.portafolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BlackJhossy
 */
@Service
public class ProyectoService implements IProyectoService {
    
    @Autowired
    public ProyectoRepository proyectRepo;

    @Override
    public List<Proyecto> getProyectos() {
        return proyectRepo.findAll();
    }

    @Override
    public Proyecto saveProyecto(Proyecto proyect) {
        return proyectRepo.save(proyect);
    }

    @Override
    public void deleteProyecto(Long id) {
        proyectRepo.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Long id) {
        return proyectRepo.findById(id).orElse(null);
    }
    
    @Override
    public Proyecto updateProyecto(Proyecto proyect){
        return proyectRepo.save(proyect);
    }
}
