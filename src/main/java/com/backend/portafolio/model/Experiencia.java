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
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre_empresa;
    private String descripcion;
    private String aneos;
    private String direccion;
    private String url_logo;
    private Long id_usuario;
    
    public Experiencia() {
    }

    public Experiencia(Long id, String nombre_empresa, String descripcion, String aneos, String direccion, String url_logo, Long id_usuario) {
        this.id = id;
        this.nombre_empresa = nombre_empresa;
        this.descripcion = descripcion;
        this.aneos = aneos;
        this.direccion = direccion;
        this.url_logo = url_logo;
        
        this.id_usuario = id_usuario;
    }
   
    
}
