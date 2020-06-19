/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.musicbv.controller;

import com.udec.musicbv.modelo.Album;
import com.udec.musicbv.modelo.Cancion;
import com.udec.musicbv.modelo.CancionJoin;
import com.udec.musicbv.modelo.Conexion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.primefaces.event.RowEditEvent;
/**
 *
 * @author Daniel Barreto, Julian vallejo
 */
@Named(value = "cancionesAdmin")
@ViewScoped
public class CancionesAdmin implements Serializable{

    @NotNull
    @Size(min = 2, max = 20)
    private String nombre;
    @NotNull    
    @DecimalMin(value = "1.0")
    @DecimalMax(value= "5.5")
    private float duracion;
    @NotNull
    private int album;
    @NotNull
    @Min(100) @Max(5000)
    private int precio;
    
    private List<Album> listaAlbumes;
    private List<CancionJoin> canciones;
       
    Conexion conexion;
    
    public CancionesAdmin() {
        
        canciones = new ArrayList<>();
        listaAlbumes = new ArrayList<>();
        conexion = new Conexion();
    }
    
    public void crearCancion(){
    
        System.out.println("Guardo cancion!");
        conexion.agregarCancion(new Cancion(nombre, duracion, album, precio));
    }
    
    @PostConstruct
    public void cargarListas(){
    
        System.out.println("Albumes menu!");
        listaAlbumes = conexion.obtenerAlbumesMenu();
        canciones = conexion.obtenerCanciones();        
    }
    
     public void onRowEdit(CancionJoin album) {        
        System.out.println("Edito Cancion!");
        conexion.editarCancion(album);
                  
    }
     
    public void eliminarCancion(int id_cancion){  
        System.out.println("Elimino Cancion!");
        conexion.eliminarCancion(id_cancion);
    }

    public void onRowCancel(RowEditEvent event) {        
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((CancionJoin) event.getObject()).getCancion());
        FacesContext.getCurrentInstance().addMessage(null, msg);
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

    public List<Album> getListaAlbumes() {
        return listaAlbumes;
    }

    public void setListaAlbumes(List<Album> listaAlbumes) {
        this.listaAlbumes = listaAlbumes;
    }

    public List<CancionJoin> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<CancionJoin> canciones) {
        this.canciones = canciones;
    }        
}
