
package com.backend.portafolio.service;

import com.backend.portafolio.model.RedesSociales;
import com.backend.portafolio.repository.RedesSocialesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BlackJhossy
 */
@Service
public class RedesSocialesService implements IRedesSocialesService{

    @Autowired
    public RedesSocialesRepository redesRepo;
    
    @Override
    public List<RedesSociales> getRedesSociales() {
        return redesRepo.findAll();
    }

    @Override
    public RedesSociales findRedesSociales(Long id) {
        return redesRepo.findById(id).orElse(null);
    }

    @Override
    public RedesSociales saveRedesSociales(RedesSociales redes) {
        return redesRepo.save(redes);
    }

    @Override
    public void deleteRedesSociales(Long id) {
        redesRepo.deleteById(id);
    }

    @Override
    public RedesSociales updateRedesSociales(RedesSociales redes) {
        return redesRepo.save(redes);
    }
    
    @Override
    public boolean existById(Long id){
        return redesRepo.existsById(id);
    } 
}
