package com.backend.portafolio.controller;

import com.backend.portafolio.model.Proyecto;
import com.backend.portafolio.security.Controller.Mensaje;
import com.backend.portafolio.service.IProyectoService;
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
public class ProyectoController {
    @Autowired
    private IProyectoService proyectServ;

    /**
     * Listar todos los Proyectos
     *
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @GetMapping("/proyectos/listar")
    @ResponseBody
    public ResponseEntity<List<Proyecto>> verProyectos() {
        List<Proyecto> listaProyectos;

        try {
            listaProyectos = proyectServ.getProyectos();
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }
        return new ResponseEntity(listaProyectos, HttpStatus.OK);
    }

    /**
     * Alta de un Proyecto
     *
     * @param proyect
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @PostMapping("/proyectos/alta")
    public ResponseEntity<?> crearProyecto(@RequestBody Proyecto proyect) {
        Object proyecto;

        try {
            if ("".equals(proyect.getNombre_proyecto()) || proyect.getNombre_proyecto() == null) {
                return new ResponseEntity(new Mensaje("Nombre proyecto Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(proyect.getDescripcion()) || proyect.getDescripcion() == null) {
                return new ResponseEntity(new Mensaje("Descripcion Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(proyect.getSistema()) || proyect.getSistema() == null) {
                return new ResponseEntity(new Mensaje("Sistema Obligatorio"), HttpStatus.BAD_REQUEST);
            }

            proyecto = proyectServ.saveProyecto(proyect);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    /**
     * Baja de un Proyecto
     *
     * @param id
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @DeleteMapping("/proyectos/baja/{id}")
    public ResponseEntity<?> deleteProyecto(@PathVariable Long id) {
        try {
            if (!proyectServ.existById(id)) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }

            proyectServ.deleteProyecto(id);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }
        return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
    }

    /**
     * Modificacion de Proyecto
     *
     * @param proyect
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @PutMapping("/proyectos/modificar")
    public ResponseEntity<?> updatePersona(@RequestBody Proyecto proyect) {
        Object proyecto;
        
        try {
            if (!proyectServ.existById(proyect.getId())) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }

            if ("".equals(proyect.getNombre_proyecto()) || proyect.getNombre_proyecto() == null) {
                return new ResponseEntity(new Mensaje("Nombre vacio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(proyect.getDescripcion()) || proyect.getDescripcion() == null) {
                return new ResponseEntity(new Mensaje("Descripcion vacio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(proyect.getSistema()) || proyect.getSistema() == null) {
                return new ResponseEntity(new Mensaje("Sistema vacio"), HttpStatus.BAD_REQUEST);
            }
            
            proyecto = proyectServ.updateProyecto(proyect);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
}
