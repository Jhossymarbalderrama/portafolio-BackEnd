
package com.backend.portafolio.service;


import com.backend.portafolio.model.Usuario;
import java.util.List;

/**
 *
 * @author BlackJhossy
 */
public interface IUsuarioService {
    public List<Usuario> getUsuarios();
    
    public Usuario findUsuario (Long id);
    
    public Usuario saveUsuario (Usuario user);
    
    public void deleteUsuario (Long id);
    
    public Usuario updateUsuario (Usuario user);
    
    public boolean existById(Long id);
}
