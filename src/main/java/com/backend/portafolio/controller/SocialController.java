package com.backend.portafolio.controller;

import com.backend.portafolio.model.RedesSociales;
import com.backend.portafolio.security.Controller.Mensaje;
import com.backend.portafolio.service.IRedesSocialesService;
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
public class SocialController {
    @Autowired
    private IRedesSocialesService redesServ;

    /**
     * Listar todas las redes sociales
     *
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @GetMapping("/redessociales/listar")
    @ResponseBody
    public ResponseEntity<List<RedesSociales>> verRedesSociales() {
        List<RedesSociales> listaRedesSociales;

        try {
            listaRedesSociales = redesServ.getRedesSociales();
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }
        return new ResponseEntity(listaRedesSociales, HttpStatus.OK);
    }

    /**
     * Alta de una red social
     *
     * @param redSocial
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @PostMapping("/redessociales/alta")
    public ResponseEntity<?> crearRedSocial(@RequestBody RedesSociales redSocial) {
        Object social;

        try {
            if ("".equals(redSocial.getNombre()) || redSocial.getNombre() == null) {
                return new ResponseEntity(new Mensaje("Nombre Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(redSocial.getLink()) || redSocial.getLink() == null) {
                return new ResponseEntity(new Mensaje("Link Obligatorio"), HttpStatus.BAD_REQUEST);
            }

            social = redesServ.saveRedesSociales(redSocial);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(social, HttpStatus.OK);
    }

    /**
     * Baja de una red social
     *
     * @param id
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @DeleteMapping("/redessociales/baja/{id}")
    public ResponseEntity<?> deleteRedSocial(@PathVariable Long id) {
        try {
            if (!redesServ.existById(id)) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }

            redesServ.deleteRedesSociales(id);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }
        return new ResponseEntity(new Mensaje("Red social Eliminada"), HttpStatus.OK);
    }

    /**
     * Modificar una red social
     *
     * @param redSocial
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @PutMapping("/redessociales/modificar")
    public ResponseEntity<?> updateRedSocial(@RequestBody RedesSociales redSocial) {
        Object social;

        try {
            if (!redesServ.existById(redSocial.getId())) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }

            if ("".equals(redSocial.getNombre()) || redSocial.getNombre() == null) {
                return new ResponseEntity(new Mensaje("Nombre vacio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(redSocial.getLink()) || redSocial.getLink() == null) {
                return new ResponseEntity(new Mensaje("Link vacio"), HttpStatus.BAD_REQUEST);
            }
            social = redesServ.updateRedesSociales(redSocial);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(social, HttpStatus.OK);
    }
}
