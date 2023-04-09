
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
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre_establecimiento;
    private String titulo;
    private String descripcion;
    private String aneos;
    private String direccion;
    private String url_logo;

    private Long id_usuario;
    
    public Educacion() {
    }

    public Educacion(Long id, String nombre_establecimiento, String titulo, String descripcion, String aneos, String direccion, String url_logo, Long id_usuario) {
        this.id = id;
        this.nombre_establecimiento = nombre_establecimiento;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.aneos = aneos;
        this.direccion = direccion;
        this.url_logo = url_logo;
        
        this.id_usuario = id_usuario;
    }
    
    
    
}
