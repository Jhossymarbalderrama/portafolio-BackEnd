package com.backend.portafolio.service;

import com.backend.portafolio.model.RedesSociales;
import java.util.List;

/**
 *
 * @author BlackJhossy
 */
public interface IRedesSocialesService {
    public List<RedesSociales> getRedesSociales();
    
    public RedesSociales findRedesSociales (Long id);
    
    public RedesSociales saveRedesSociales (RedesSociales user);
    
    public void deleteRedesSociales (Long id);
    
    public RedesSociales updateRedesSociales (RedesSociales user);
}
