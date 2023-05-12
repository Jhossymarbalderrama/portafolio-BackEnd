package com.backend.portafolio.controller;

import com.backend.portafolio.model.Educacion;
import com.backend.portafolio.security.Controller.Mensaje;
import com.backend.portafolio.service.IEducacionService;
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
@CrossOrigin(origins = {"http://localhost:4200","https://my-portafolio-7abab.web.app"})
@RequestMapping("/api")
public class EducacionController {
    @Autowired
    private IEducacionService eduServ;

    /**
     * Listar todas las Educaciones
     *
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @GetMapping("/educaciones/listar")
    @ResponseBody
    public ResponseEntity<List<Educacion>> verEducaciones() {
        List<Educacion> listEducaciones;
        try{
            listEducaciones = eduServ.getEducaciones();
        }catch(Exception e){
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }
        return new ResponseEntity(listEducaciones, HttpStatus.OK);
    }

    /**
     * Alta de una Educacion
     *
     * @param edu
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @PostMapping("/educaciones/alta")
    public ResponseEntity<?> crearEducacion(@RequestBody Educacion edu) {
        Object educacion;
        
        try {
            if ("".equals(edu.getTitulo()) || edu.getTitulo() == null) {
                return new ResponseEntity(new Mensaje("Titulo Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(edu.getDescripcion()) || edu.getDescripcion() == null) {
                return new ResponseEntity(new Mensaje("Descripcion Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(edu.getNombre_establecimiento()) || edu.getNombre_establecimiento() == null) {
                return new ResponseEntity(new Mensaje("Nombre del Establecimiento Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(edu.getDireccion()) || edu.getDireccion() == null) {
                return new ResponseEntity(new Mensaje("Direccion Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(edu.getAneos()) || edu.getAneos() == null) {
                return new ResponseEntity(new Mensaje("Año/s Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            
            educacion = eduServ.saveEducacion(edu);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    /**
     * Baja de una Educacion
     *
     * @param id
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @DeleteMapping("/educaciones/baja/{id}")
    public ResponseEntity<?> deleteEducacion(@PathVariable("id") Long id) {
        try {
            if (!eduServ.existById(id)) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }

            eduServ.deleteEducacion(id);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }
        return new ResponseEntity(new Mensaje("Educacion Eliminada"), HttpStatus.OK);
    }

    /**
     * Modificacion de una Educacion
     *
     * @param edu
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @PutMapping("/educaciones/modificar")
    public ResponseEntity<?> updatePersona(@RequestBody Educacion edu) {
        Object uducacion;
        try {
            if (!eduServ.existById(edu.getId())) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }

            if ("".equals(edu.getTitulo()) || edu.getTitulo() == null) {
                return new ResponseEntity(new Mensaje("Titulo Vacio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(edu.getDescripcion()) || edu.getDescripcion() == null) {
                return new ResponseEntity(new Mensaje("Descripcion Vacio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(edu.getNombre_establecimiento()) || edu.getNombre_establecimiento() == null) {
                return new ResponseEntity(new Mensaje("Nombre del establecimiento Vacio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(edu.getDireccion()) || edu.getDireccion() == null) {
                return new ResponseEntity(new Mensaje("Direccion Vacio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(edu.getAneos()) || edu.getAneos() == null) {
                return new ResponseEntity(new Mensaje("Año/s Vacio"), HttpStatus.BAD_REQUEST);
            }
            
            uducacion = eduServ.updateEducacion(edu);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(uducacion, HttpStatus.OK);
    }
}
