package com.backend.portafolio.controller;

import com.backend.portafolio.model.HardSoftSkills;
import com.backend.portafolio.security.Controller.Mensaje;
import com.backend.portafolio.service.IHardSoftSkillsService;
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
public class HabilidadController {

    @Autowired
    private IHardSoftSkillsService hssServ;

    /**
     * Listar todas las habilidades
     *
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @GetMapping("/hss/listar")
    @ResponseBody
    public ResponseEntity<List<HardSoftSkills>> verHardSoftSkills() {
        List<HardSoftSkills> listaHSS;
        try {
            listaHSS = hssServ.getHSS();
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }
        return new ResponseEntity(listaHSS, HttpStatus.OK);
    }

    /**
     * Alta de una Habilidad
     *
     * @param hss
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @PostMapping("/hss/alta")
    public ResponseEntity<?> crearHardSoftSkill(@RequestBody HardSoftSkills hss) {
        HardSoftSkills nuevoHss = new HardSoftSkills();

        try {
            if (hss.getTitulo() == "" || hss.getTitulo() == null) {
                return new ResponseEntity(new Mensaje("Titulo Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if (hss.getDetalle() == "" || hss.getDetalle() == null) {
                return new ResponseEntity(new Mensaje("Detalle Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if (hss.getPorcentaje() == null) {
                return new ResponseEntity(new Mensaje("Porcentaje Obligatorio"), HttpStatus.BAD_REQUEST);
            }
            nuevoHss = hssServ.saveHSS(hss);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(nuevoHss, HttpStatus.OK);
    }

    /**
     * Baja de una Habilidad
     *
     * @param id
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @DeleteMapping("/hss/baja/{id}")
    public ResponseEntity<?> deleteHardSoftSkill(@PathVariable Long id) {
        try {
            if (!hssServ.existById(id)) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }

            hssServ.deleteHSS(id);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }
        return new ResponseEntity(new Mensaje("Habilidad Eliminada"), HttpStatus.OK);
    }

    /**
     * Modificar una Habilidad
     *
     * @param hss
     * @return ResponseEntity((Mensaje | Object), HttpStatus)
     */
    @PutMapping("/hss/modificar")
    public ResponseEntity<?> updateHardSoftSkill(@RequestBody HardSoftSkills hss) {
        HardSoftSkills nuevoHss = new HardSoftSkills();
        try {
            if (!hssServ.existById(hss.getId())) {
                return new ResponseEntity(new Mensaje("No existe el numero de ID"), HttpStatus.NOT_FOUND);
            }

            if ("".equals(hss.getTitulo()) || hss.getTitulo() == null) {
                return new ResponseEntity(new Mensaje("Titulo vacio"), HttpStatus.BAD_REQUEST);
            }
            if ("".equals(hss.getDetalle()) || hss.getDetalle() == null) {
                return new ResponseEntity(new Mensaje("Detalle vacio"), HttpStatus.BAD_REQUEST);
            }
            if (hss.getPorcentaje() == null) {
                return new ResponseEntity(new Mensaje("Porcentaje vacio"), HttpStatus.BAD_REQUEST);
            }
 
            nuevoHss = hssServ.updateHSS(hss);            
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("¡Ups!... Creo que ocurrio un problema... :/"), HttpStatus.FOUND);
        }

        return new ResponseEntity(nuevoHss, HttpStatus.OK);
    }
}
