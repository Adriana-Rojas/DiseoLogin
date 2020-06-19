/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elecciones.modelo.pojo;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 *
 * @author Daniel Barreto
 */
public class Candidato  implements Serializable {
    
    /**
     * Documento de identidad del candidato
     */
    @Min(7)
    private Integer cedula;
    
    /**
     * Nombre del candidato
     */
    @Size(min=2,max=30)
    private String nombre;
    
    /**
     * Apellido del candidato
     */
    @Size(min=2,max=30)
    private String apellido;
    
    /**
     * Numero de votos
     */
    private Integer votos;
    
    /**
     * Ruta de la foto del usuario
     */
    private String foto;

    /**
     * Constructor inicial
     */
    public Candidato() {
        this.votos = 0;
    }

    /**
     * Constructor del candidato
     * @param cedula documento del candidato
     * @param nombre nombre del candidato
     * @param apellido apellido del candidato
     * @param foto ubicacion de la imagen del candidato
     */
    public Candidato(Integer cedula, String nombre, String apellido, String foto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;
        this.votos = 0;
    }

    /**
     * Getter de la foto
     * @return Foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Setter de la foto
     * @param foto 
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Getter de la cedula
     * @return Cedula
     */
    public Integer getCedula() {
        return cedula;
    }

    /**
     * Setter de la cedula
     * @param cedula 
     */
    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    /**
     * Getter del nombre
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del apellido
     * @return Apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Setter del apellido
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Getter de los votos
     * @return Votos
     */
    public Integer getVotos() {
        return votos;
    }

    /**
     * Setter de los votos
     * @param votos 
     */
    public void setVotos(Integer votos) {
        this.votos = votos;
    }
}

