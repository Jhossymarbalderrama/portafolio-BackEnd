/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portafolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author BlackJhossy
 */
@Getter @Setter
@Entity
public class HardSoftSkills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String detalle;
    private Long porcentaje;
    
    private Long id_usuario;
    
    public HardSoftSkills() {
    }

    public HardSoftSkills(Long id, String titulo, String detalle, Long porcentaje, Long id_usuario) {
        this.id = id;
        this.titulo = titulo;
        this.detalle = detalle;
        this.porcentaje = porcentaje;
        this.id_usuario = id_usuario;
    }
    
    
}
