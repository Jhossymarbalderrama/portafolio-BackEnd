package com.backend.portafolio.controller;

import com.backend.portafolio.model.Persona;
import com.backend.portafolio.security.Controller.Mensaje;
import com.backend.portafolio.service.IPersonaService;
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
public class PersonaController {

    @Autowired
    private IPersonaService persoServ;

    /**
     * Listar todas las Personas
     *
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @GetMapping("/personas/listar")
    @ResponseBody
    public ResponseEntity<List<Persona>> verPersonas() {
        List<Persona> listaPersonas;
        try {
            listaPersonas = persoServ.getPersonas();
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }
        return new ResponseEntity(listaPersonas, HttpStatus.OK);
    }

    /**
     * Traer una Persona por id
     *
     * @param id
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @GetMapping("/personas/listar/{id}")
    public ResponseEntity<?> verPersona(@PathVariable("id") Long id) {
        Persona persona = new Persona();

        try {
            if (!persoServ.existById(id)) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }
            persona = persoServ.findPersona(id);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(persona, HttpStatus.OK);
    }

    /**
     * Alta de Personas
     *
     * @param per
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @PostMapping("/personas/alta")
    public ResponseEntity<?> createPersona(@RequestBody Persona per) {
        Persona persona = new Persona();

        try {
            if ("".equals(per.getNombre()) || per.getNombre() == null) {
                return new ResponseEntity(new Mensaje("Nombre Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(per.getApellido()) || per.getApellido() == null) {
                return new ResponseEntity(new Mensaje("Apellido Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if (per.getEdad() == null || per.getEdad() <= 0) {
                return new ResponseEntity(new Mensaje("Edad Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if (per.getTelefono() == null || per.getTelefono() <= 9999999) {
                return new ResponseEntity(new Mensaje("Telefono Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if (per.getCelular() == null || per.getCelular() <= 9999999) {
                return new ResponseEntity(new Mensaje("Celular Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(per.getEmail()) || per.getEmail() == null) {
                return new ResponseEntity(new Mensaje("Email Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(per.getTitulo()) || per.getTitulo() == null) {
                return new ResponseEntity(new Mensaje("Titulo Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if (per.getSobre_mi() == null) {
                return new ResponseEntity(new Mensaje("Sobre mi Obligatorio"), HttpStatus.BAD_REQUEST);
            }

            persona = persoServ.savePersona(per);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(persona, HttpStatus.OK);
    }

    /**
     * Baja de una Persona
     *
     * @param id
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @DeleteMapping("/personas/baja/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable("id") Long id) {
        try {
            if (!persoServ.existById(id)) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }

            persoServ.deletePersona(id);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }
        return new ResponseEntity(new Mensaje("Persona Eliminada"), HttpStatus.OK);
    }

    /**
     *
     *
     * @param persona
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @PutMapping("/personas/modificar")
    public ResponseEntity<?> updatePersona(@RequestBody Persona persona) {
        Persona NuevaPersona = new Persona();
        
        try {
            if (!persoServ.existById(persona.getId())) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }

            if ("".equals(persona.getNombre()) || persona.getNombre() == null) {
                return new ResponseEntity(new Mensaje("Nombre Vacio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(persona.getApellido()) || persona.getApellido() == null) {
                return new ResponseEntity(new Mensaje("Apellido Vacio"), HttpStatus.BAD_REQUEST);
            }
            if (persona.getEdad() == null || persona.getEdad() <= 0) {
                return new ResponseEntity(new Mensaje("Edad Vacio"), HttpStatus.BAD_REQUEST);
            }
            if (persona.getTelefono() == null || persona.getTelefono() <= 9999999) {
                return new ResponseEntity(new Mensaje("Telefono Vacio"), HttpStatus.BAD_REQUEST);
            }
            if (persona.getCelular() == null || persona.getCelular() <= 9999999) {
                return new ResponseEntity(new Mensaje("Celular Vacio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(persona.getEmail()) || persona.getEmail() == null) {
                return new ResponseEntity(new Mensaje("Email Vacio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(persona.getTitulo()) || persona.getTitulo() == null) {
                return new ResponseEntity(new Mensaje("Titulo Vacio"), HttpStatus.BAD_REQUEST);
            }
            if (persona.getSobre_mi() == null) {
                return new ResponseEntity(new Mensaje("Sobre mi Vacio"), HttpStatus.BAD_REQUEST);
            }
            
            NuevaPersona = persoServ.updatePersona(persona);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(NuevaPersona, HttpStatus.OK);
    }
}
