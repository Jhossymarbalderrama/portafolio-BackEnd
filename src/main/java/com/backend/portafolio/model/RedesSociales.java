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
public class RedesSociales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String link;

    private Long id_usuario;
    
    public RedesSociales() {
    }

    public RedesSociales(Long id, String nombre, String link,Long id_usuario) {
        this.id = id;
        this.nombre = nombre;
        this.link = link;
        this.id_usuario = id_usuario;
    }
    
    
}
