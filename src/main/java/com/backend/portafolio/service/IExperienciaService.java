/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.portafolio.service;


import com.backend.portafolio.model.Experiencia;
import java.util.List;

/**
 *
 * @author BlackJhossy
 */
public interface IExperienciaService {
   public List<Experiencia> getExperiencias();
    
   public Experiencia findExperiencia (Long id); 
   
    public Experiencia saveExperiencia (Experiencia exp);
    
    public void deleteExperiencia (Long id);
    
    public Experiencia updateExperiencia(Experiencia exp);
}
