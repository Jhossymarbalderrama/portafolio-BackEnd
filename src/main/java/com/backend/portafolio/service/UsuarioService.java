
package com.backend.portafolio.service;

import com.backend.portafolio.model.Usuario;
import com.backend.portafolio.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BlackJhossy
 */
@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    public UsuarioRepository userRepo;
    
    @Override
    public List<Usuario> getUsuarios() {
        return userRepo.findAll();
    }

    @Override
    public Usuario saveUsuario(Usuario user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteUsuario(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public Usuario findUsuario(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    
    @Override
    public Usuario updateUsuario(Usuario user){
        return userRepo.save(user);
    }
}
