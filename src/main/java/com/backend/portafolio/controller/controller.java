package com.backend.portafolio.controller;

import com.backend.portafolio.model.Educacion;
import com.backend.portafolio.model.Experiencia;
import com.backend.portafolio.model.Persona;
import com.backend.portafolio.model.Proyecto;
import com.backend.portafolio.model.RedesSociales;
import com.backend.portafolio.model.Usuario;

import com.backend.portafolio.service.IEducacionService;
import com.backend.portafolio.service.IExperienciaService;
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
@CrossOrigin(origins = "http://localhost:4200")
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
   
   @PutMapping ("/personas/modificar/{id}")
   public Persona editarPersona (@PathVariable Long id,
                                 @RequestParam ("nombre") String newName,
                                 @RequestParam ("apellido") String lastName,
                                 @RequestParam ("edad") Long edad,
                                 @RequestParam ("telefono") Long newPhone,
                                 @RequestParam ("celular") Long newSmartPhone,
                                 @RequestParam ("email") String newEmail,
                                 @RequestParam ("titulo") String newTitle,
                                 @RequestParam ("sobre_mi") String newAboutMe,
                                 @RequestParam ("url_banner_perfil") String newUrlBanner,
                                 @RequestParam ("url_foto_perfil") String newUrlPerfil){
       
       Persona perso = persoServ.findPersona(id);
       
       perso.setNombre(newName);
       perso.setApellido(lastName);
       perso.setEdad(edad);
       perso.setTelefono(newPhone);
       perso.setCelular(newSmartPhone);
       perso.setEmail(newEmail);
       perso.setTitulo(newTitle);
       perso.setSobre_mi(newAboutMe);
       perso.setUrl_banner_perfil(newUrlBanner);
       perso.setUrl_foto_perfil(newUrlPerfil);

       
       persoServ.savePersona(perso);                
        
       return perso;       
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
   
   @PostMapping("/usuarios/alta")
   public Usuario createUsuario(@RequestBody Usuario user){
       return userSer.saveUsuario(user);
   }
   
   @DeleteMapping("/usuarios/baja/{id}")
   public void deleteUsuario(@PathVariable Long id){
       userSer.deleteUsuario(id);      
   }
   
   @PutMapping ("/usuarios/modificar/{id}")
   public Usuario editarUsuario (@PathVariable Long id,
                                 @RequestParam ("usuario") String newUser,
                                 @RequestParam ("contraseña") String newPassw,
                                 @RequestParam ("id_usuario") Long new_id_usuario){
       
       Usuario user = userSer.findUsuario(id);
       
       user.setUsuario(newUser);
       user.setContraseña(newPassw);
       user.setId_persona(new_id_usuario);
       
       userSer.saveUsuario(user);
       
       return user;
   }
   
   @PutMapping("/usuarios/modificar")
   public Usuario updatePersona(@RequestBody Usuario usuario){              
       return userSer.updateUsuario(usuario);
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
   
   @PutMapping ("/experiencias/modificar/{id}")
   public Experiencia editarExperiencia (@PathVariable Long id,
                                 @RequestParam ("nombre_empresa") String newName,
                                 @RequestParam ("descripcion") String newDescription,
                                 @RequestParam ("aneos") String newAneos,
                                 @RequestParam ("direccion") String newAddress,
                                 @RequestParam ("url_logo") String newUrlLogo
                                 ){
       
       Experiencia exp = expServ.findExperiencia(id);
       
       exp.setNombre_empresa(newName);
       exp.setDescripcion(newDescription);
       exp.setAneos(newAneos);
       exp.setDireccion(newAddress);
       exp.setUrl_logo(newUrlLogo);
       
       expServ.saveExperiencia(exp);
       
       return exp;
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
   
   @PutMapping ("/educaciones/modificar/{id}")
   public Educacion editarEducacion (@PathVariable Long id,
                                 @RequestParam ("nombre_establecimiento") String newName,
                                 @RequestParam ("titulo") String newtitle,
                                 @RequestParam ("descripcion") String newDescription,
                                 @RequestParam ("aneos") String newAneos,
                                 @RequestParam ("direccion") String newAddress,
                                 @RequestParam ("url_logo") String newUrlLogo
                                 ){
       
       Educacion edu = eduServ.findEducacion(id);
       
       edu.setNombre_establecimiento(newName);
       edu.setTitulo(newtitle);
       edu.setDescripcion(newDescription);
       edu.setAneos(newAneos);
       edu.setDireccion(newAddress);
       edu.setUrl_logo(newUrlLogo);
       
       eduServ.saveEducacion(edu);
       
       return edu;
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
   
   @PutMapping ("/proyectos/modificar/{id}")
   public Proyecto editarProyecto (@PathVariable Long id,
                                 @RequestParam ("nombre_proyecto") String newName,             
                                 @RequestParam ("descripcion") String newDescription,
                                 @RequestParam ("sistema") String newSistem
                                 ){
       
       Proyecto proy = proyectServ.findProyecto(id);
       
       proy.setNombre_proyecto(newName);
       proy.setDescripcion(newDescription);
       proy.setSistema(newSistem);

       proyectServ.saveProyecto(proy);
       
       return proy;
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
   
    @PutMapping ("/redessociales/modificar/{id}")
   public RedesSociales editarRedSocial (@PathVariable Long id,
                                 @RequestParam ("nombre") String newName,             
                                 @RequestParam ("link") String newLink
                                 ){
       
       RedesSociales red = redesServ.findRedesSociales(id);
       
       red.setNombre(newName);
       red.setLink(newLink);

       redesServ.saveRedesSociales(red);
       
       return red;
   }
   
   @PutMapping("/redessociales/modificar")
   public RedesSociales updateRedSocial(@RequestBody RedesSociales redSocial){              
       return redesServ.updateRedesSociales(redSocial);
   }
   
}
