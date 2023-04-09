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
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre_proyecto;
    private String descripcion;
    private String sistema;

    private Long id_usuario;
    
    public Proyecto() {
    }

    public Proyecto(Long id, String nombre_proyecto, String descripcion, String sistema, Long id_usuario) {
        this.id = id;
        this.nombre_proyecto = nombre_proyecto;
        this.descripcion = descripcion;
        this.sistema = sistema;
        
        this.id_usuario = id_usuario;
    }
       
}
