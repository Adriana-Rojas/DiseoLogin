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
public class Cancion implements Serializable{
        
    private int id;
    private String nombre;    
    private float duracion;    
    private int album;    
    private int precio;

    public Cancion() {
    }

    public Cancion(String nombre, float duracion, int album, int precio) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.album = album;
        this.precio = precio;
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

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public int getAlbum() {
        return album;
    }

    public void setAlbum(int album) {
        this.album = album;
    }    

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
