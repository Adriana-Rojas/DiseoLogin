/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.musicbv.modelo;

import java.io.Serializable;

/**
 *
 * @author Daniel Barreto, Julian vallejo
 */
public class Album implements Serializable{
    
    private int id;
    private String nombre;
    private int artista;

    public Album() {
    }

    public Album(String nombre, int artista) {
        this.nombre = nombre;
        this.artista = artista;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }        
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getArtista() {
        return artista;
    }

    public void setArtista(int artista) {
        this.artista = artista;
    }
    
    
    
}
