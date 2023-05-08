package com.backend.portafolio.controller;

import com.backend.portafolio.model.Educacion;
import com.backend.portafolio.model.Experiencia;
import com.backend.portafolio.model.HardSoftSkills;
import com.backend.portafolio.model.Persona;
import com.backend.portafolio.model.Proyecto;
import com.backend.portafolio.model.RedesSociales;
import com.backend.portafolio.model.Usuario;

import com.backend.portafolio.service.IEducacionService;
import com.backend.portafolio.service.IExperienciaService;
import com.backend.portafolio.service.IHardSoftSkillsService;
import com.backend.portafolio.service.IPersonaService;
import com.backend.portafolio.service.IProyectoService;
import com.backend.portafolio.service.IRedesSocialesService;
import com.backend.portafolio.service.IUsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author BlackJhossy
 */

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://my-portafolio-7abab.web.app")
@RequestMapping("/api")
public class controller {
    
   //MODEL PERSONA
   @Autowired
   private IPersonaService persoServ;
   
   @GetMapping("/personas/listar")
   @ResponseBody
   public List<Persona> verPersonas(){
       return persoServ.getPersonas();
   }
   
   @GetMapping("/personas/listar/{id}")
   public Persona verPersona(@PathVariable Long id){
       return persoServ.findPersona(id);
   }
   
   @PostMapping("/personas/alta")
   public Persona createPersona(@RequestBody Persona per){
       return persoServ.savePersona(per);     
   }
   
   @DeleteMapping("/personas/baja/{id}")
   public void deletePersona(@PathVariable Long id){
       persoServ.deletePersona(id);             
   }
   
   @PutMapping("/personas/modificar")
   public Persona updatePersona(@RequestBody Persona persona){              
       return persoServ.updatePersona(persona);
   }
   
    //MODEL USUARIO    
   
   @Autowired
   private IUsuarioService userSer;
   
   @GetMapping("/usuarios/listar")
   @ResponseBody
   public List<Usuario> verUsuarios(){
       return userSer.getUsuarios();
   } 
   
   @GetMapping("/usuarios/listar/{id}")
   public Usuario verUsuario(@PathVariable Long id){
       return userSer.findUsuario(id);       
   }
   
   @PostMapping("/usuarios/alta")
   public Usuario createUsuario(@RequestBody Usuario user){      
       return userSer.saveUsuario(user);
   }
   
   @DeleteMapping("/usuarios/baja/{id}")
   public void deleteUsuario(@PathVariable Long id){
       userSer.deleteUsuario(id);      
   }
   
   @PutMapping("/usuarios/modificar")
   public Usuario updateUsuario(@RequestBody Usuario user){     
       return userSer.updateUsuario(user);       
   }
   
   //MODEL EXPERIENCIA
   @Autowired
   private IExperienciaService expServ;
   
   @GetMapping("/experiencias/listar")
   @ResponseBody
   public List<Experiencia> verExperiencias(){
       return expServ.getExperiencias();
   } 
   
   @PostMapping("/experiencias/alta")
   public Experiencia createExperiencia(@RequestBody Experiencia exp){
       return expServ.saveExperiencia(exp);
   }
   
   @DeleteMapping("/experiencias/baja/{id}")
   public void deleteExperiencia(@PathVariable Long id){
       expServ.deleteExperiencia(id);
   }
      
   @PutMapping("/experiencias/modificar")
   public Experiencia updatePersona(@RequestBody Experiencia exp){              
       return expServ.updateExperiencia(exp);
   }
   
   //MODEL EDUCACION
   @Autowired
   private IEducacionService eduServ;
   
   @GetMapping("/educaciones/listar")
   @ResponseBody
   public List<Educacion> verEducaciones(){
       return eduServ.getEducaciones();
   } 
   
   @PostMapping("/educaciones/alta")
   public Educacion crearEducacion(@RequestBody Educacion edu){
       return eduServ.saveEducacion(edu);
   }
   
   @DeleteMapping("/educaciones/baja/{id}")
   public void deleteEducacion(@PathVariable Long id){
       eduServ.deleteEducacion(id);
   }
   
   @PutMapping("/educaciones/modificar")
   public Educacion updatePersona(@RequestBody Educacion edu){              
       return eduServ.updateEducacion(edu);
   }
   
   //MODEL PROYECTO
   @Autowired
   private IProyectoService proyectServ;
   
   @GetMapping("/proyectos/listar")
   @ResponseBody
   public List<Proyecto> verProyectos(){
       return proyectServ.getProyectos();
   } 
   
   @PostMapping("/proyectos/alta")
   public Proyecto crearProyecto(@RequestBody Proyecto proyect){
       return proyectServ.saveProyecto(proyect);
   }
   
   @DeleteMapping("/proyectos/baja/{id}")
   public void deleteProyecto(@PathVariable Long id){
       proyectServ.deleteProyecto(id);
   }
   
   @PutMapping("/proyectos/modificar")
   public Proyecto updatePersona(@RequestBody Proyecto proyect){              
       return proyectServ.updateProyecto(proyect);
   }
   
   //REDES SOCIALES
   @Autowired
   private IRedesSocialesService redesServ;
   
   @GetMapping("/redessociales/listar")
   @ResponseBody
   public List<RedesSociales> verRedesSociales(){
       return redesServ.getRedesSociales();
   } 
   
   @PostMapping("/redessociales/alta")
   public RedesSociales crearRedSocial(@RequestBody RedesSociales redSocial){
       return redesServ.saveRedesSociales(redSocial);
   }
   
   @DeleteMapping("/redessociales/baja/{id}")
   public void deleteRedSocial(@PathVariable Long id){
       redesServ.deleteRedesSociales(id);
   }
   
   @PutMapping("/redessociales/modificar")
   public RedesSociales updateRedSocial(@RequestBody RedesSociales redSocial){              
       return redesServ.updateRedesSociales(redSocial);
   }
   
   //HARD SOFT SKILLS
   @Autowired
   private IHardSoftSkillsService hssServ;
   
   @GetMapping("/hss/listar")
   @ResponseBody
   public List<HardSoftSkills> verHardSoftSkills(){
       return hssServ.getHSS();
   } 
   
   @PostMapping("/hss/alta")
   public HardSoftSkills crearHardSoftSkill(@RequestBody HardSoftSkills hss){
       return hssServ.saveHSS(hss);
   }
   
   @DeleteMapping("/hss/baja/{id}")
   public void deleteHardSoftSkill(@PathVariable Long id){
       hssServ.deleteHSS(id);
   }
   
   @PutMapping("/hss/modificar")
   public HardSoftSkills updateHardSoftSkill(@RequestBody HardSoftSkills hss){              
       return hssServ.updateHSS(hss);
   }
}
