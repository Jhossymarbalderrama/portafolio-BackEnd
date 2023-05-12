package com.backend.portafolio.controller;

import com.backend.portafolio.model.Usuario;
import com.backend.portafolio.security.Controller.Mensaje;
import com.backend.portafolio.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BlackJhossy
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://my-portafolio-7abab.web.app"})
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private IUsuarioService userSer;

    /**
     * Listar todos los Usuarios
     *
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @GetMapping("/usuarios/listar")
    @ResponseBody
    public ResponseEntity<List<Usuario>> verUsuarios() {
        List<Usuario> listaUsuarios;
        try {
            listaUsuarios = userSer.getUsuarios();
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }
        return new ResponseEntity(listaUsuarios, HttpStatus.OK);
    }

    /**
     * Traer un Usuario por id
     *
     * @param id
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @GetMapping("/usuarios/listar/{id}")
    public ResponseEntity<?> verUsuario(@PathVariable("id") Long id) {
        Usuario usuario = new Usuario();

        try {
            if (!userSer.existById(id)) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }
            usuario = userSer.findUsuario(id);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    /**
     * Alta de un Usuario
     *
     * @param user
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @PostMapping("/usuarios/alta")
    public ResponseEntity<?> createUsuario(@RequestBody Usuario user) {
        Usuario usuario = new Usuario();

        try {
            if (user.getUsuario() == null || "".equals(user.getUsuario())) {
                return new ResponseEntity(new Mensaje("Usuario Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if (user.getContraseña() == null || "".equals(user.getContraseña())) {
                return new ResponseEntity(new Mensaje("Contraseña Obligatorio"), HttpStatus.BAD_REQUEST);
            }

            usuario = userSer.saveUsuario(user);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    /**
     * Baja de Usuario
     *
     * @param id
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @DeleteMapping("/usuarios/baja/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") Long id) {
        try {
            if (!userSer.existById(id)) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }
            userSer.deleteUsuario(id);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(new Mensaje("Usuario Eliminado"), HttpStatus.OK);
    }

    /**
     * Modificar Usuario
     *
     * @param user
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @PutMapping("/usuarios/modificar")
    public ResponseEntity<Object> updateUsuario(@RequestBody Usuario user) {
        Usuario usuario =  new Usuario();
        try {
            if (!userSer.existById(user.getId())) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }

            if ("".equals(user.getUsuario()) || user.getUsuario() == null) {
                return new ResponseEntity(new Mensaje("Usuario vacio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(user.getContraseña()) || user.getContraseña() == null) {
                return new ResponseEntity(new Mensaje("Contraseña vacio"), HttpStatus.BAD_REQUEST);
            }
            
            usuario = userSer.updateUsuario(user);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
