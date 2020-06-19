/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.musicbv.controller;

import com.udec.musicbv.modelo.Album;
import com.udec.musicbv.modelo.AlbumJoin;
import com.udec.musicbv.modelo.Artista;
import com.udec.musicbv.modelo.Conexion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Daniel Barreto, Julian vallejo
 */
@Named(value = "albumesAdmin")
@ViewScoped
public class AlbumesAdmin implements Serializable {

    @NotNull
    @Size(min = 2, max = 20)
    private String nombre;
    @NotNull
    private int artista;   
        
    private List<Artista> listaArtistas;
    private List<AlbumJoin> albumes;
    
    Conexion conexion;

    public AlbumesAdmin() {        
        albumes = new ArrayList<>();
        listaArtistas = new ArrayList<>();
        conexion = new Conexion();
    }
    /**
     * metodo para validar la creacion del album 
     */
    public void crearAlbum(){
    
        System.out.println("Guardo Artista!");
        
        conexion.agregarAlbum(new Album(nombre, artista));
        PrimeFaces.current().ajax().update("form:panel");
    }
    /**
     * metodo para eliminar el album
     * @param id_album 
     */
    public void eliminarAlbum(int id_album){
            
        System.out.println("Elimino Album");
        conexion.eliminarAlbum(id_album);
        
    }
    /**
     * metodo para cargar las listas de artistas
     */
    @PostConstruct
    public void cargarListas(){
        System.out.println("Artistas menu!");        
        albumes = conexion.obtenerAlbumes();
        listaArtistas = conexion.obtenerArtistas();
    }
    /**
     * metodo para editar el album
     * @param album 
     */
    public void onRowEdit(AlbumJoin album) {        
        System.out.println("Edito Album!");
        conexion.editarAlbum(album);            
    }
/**
 * metodo para cancelar la edicion del album 
 * @param event 
 */
    public void onRowCancel(RowEditEvent event) {        
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((AlbumJoin) event.getObject()).getArtista());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public List<Artista> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(List<Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
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

    public List<AlbumJoin> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(List<AlbumJoin> albumes) {
        this.albumes = albumes;
    }    
}
