package com.backend.portafolio.controller;

import com.backend.portafolio.model.Experiencia;
import com.backend.portafolio.security.Controller.Mensaje;
import com.backend.portafolio.service.IExperienciaService;
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
public class ExperienciaController {

    @Autowired
    private IExperienciaService expServ;

    /**
     * Listar todas las Experiencias
     *
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @GetMapping("/experiencias/listar")
    @ResponseBody
    public ResponseEntity<List<Experiencia>> verExperiencias() {
        List<Experiencia> listaExperiencias;
        try {
            listaExperiencias = expServ.getExperiencias();
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }
        return new ResponseEntity(listaExperiencias, HttpStatus.OK);
    }

    /**
     * Alta de una Experiencia
     *
     * @param exp
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @PostMapping("/experiencias/alta")
    public ResponseEntity<?> createExperiencia(@RequestBody Experiencia exp) {
        Experiencia experiencia = new Experiencia();

        try {
            if ("".equals(exp.getNombre_empresa()) || exp.getNombre_empresa() == null) {
                return new ResponseEntity(new Mensaje("Nombre Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(exp.getDescripcion()) || exp.getDescripcion() == null) {
                return new ResponseEntity(new Mensaje("Descripcion Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(exp.getDireccion()) || exp.getDireccion() == null) {
                return new ResponseEntity(new Mensaje("Direccion Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(exp.getAneos()) || exp.getAneos() == null) {
                return new ResponseEntity(new Mensaje("Año/s Obligatorio"), HttpStatus.BAD_REQUEST);
            }

            experiencia = expServ.saveExperiencia(exp);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    /**
     * Baja de una Experiencia
     *
     * @param id
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @DeleteMapping("/experiencias/baja/{id}")
    public ResponseEntity<?> deleteExperiencia(@PathVariable("id") Long id) {
        try {
            if (!expServ.existById(id)) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }

            expServ.deleteExperiencia(id);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }
        return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
    }

    /**
     * Modificacion de una Experiencia
     *
     * @param exp
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @PutMapping("/experiencias/modificar")
    public ResponseEntity<?> updatePersona(@RequestBody Experiencia exp) {
        Experiencia experiencia = new Experiencia();
        
        try {
            if (!expServ.existById(exp.getId())) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }

            if ("".equals(exp.getNombre_empresa()) || exp.getNombre_empresa() == null) {
                return new ResponseEntity(new Mensaje("Nombre vacio"), HttpStatus.NOT_FOUND);
            }
            if ("".equals(exp.getDescripcion()) || exp.getDescripcion() == null) {
                return new ResponseEntity(new Mensaje("Descripcion vacio"), HttpStatus.NOT_FOUND);
            }
            if ("".equals(exp.getDireccion()) || exp.getDireccion() == null) {
                return new ResponseEntity(new Mensaje("Direccion vacio"), HttpStatus.NOT_FOUND);
            }
            if ("".equals(exp.getAneos()) || exp.getAneos() == null) {
                return new ResponseEntity(new Mensaje("Año/s vacio"), HttpStatus.NOT_FOUND);
            }
            
            experiencia = expServ.updateExperiencia(exp);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
}
