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
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String usuario;
    private String contraseña;
    private Long id_persona;
    
    public Usuario() {
    }

    public Usuario(Long id, String usuario, String contraseña, Long id_persona) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.id_persona = id_persona;
    }
    
}
