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
public class Persona{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private String apellido;
    private Long edad;
    private Long telefono;
    private Long celular;
    private String email;
    private String titulo;
    private String sobre_mi;
    private String url_banner_perfil;
    private String url_foto_perfil;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, Long edad, Long telefono, Long celular, String email, String titulo, String sobre_mi, String url_banner_perfil, String url_foto_perfil) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.titulo = titulo;
        this.sobre_mi = sobre_mi;
        this.url_banner_perfil = url_banner_perfil;
        this.url_foto_perfil = url_foto_perfil;
    } 
}
