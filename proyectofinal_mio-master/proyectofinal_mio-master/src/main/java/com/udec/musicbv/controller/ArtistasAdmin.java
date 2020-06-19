/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.musicbv.controller;

import com.udec.musicbv.modelo.Artista;
import com.udec.musicbv.modelo.Conexion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Daniel Barreto, Julian vallejo
 */
@Named(value = "artistasAdmin")
@ViewScoped
public class ArtistasAdmin implements Serializable {

    @NotNull
    @Size(min=2,max=20)
    private String nombre;
    @NotNull
    @Size(min=2,max=20)
    private String apellido;
    @NotNull(message = "Seleccione una fecha!")
    @Past(message = "Seleccione una fecha anterior a hoy")    
    private Date fechaNacimiento;
    @NotNull
    private String nacionalidad;
   

    private List<Artista> artistas;

    Conexion conexion;

    public ArtistasAdmin() {        
        artistas = new ArrayList<>();
        conexion = new Conexion();
    }      
/**
 * metodo para crear artista
 */
    public void crearArtista() {
        System.out.println("Guardo Artista!");
        
        conexion.agregarArtista(new Artista(nombre, apellido, fechaNacimiento, nacionalidad));
        PrimeFaces.current().ajax().update("form:panel");               
    }
    
    @PostConstruct
    /**
     * metodo para cargar artistas
     */
    public void cargarArtistas(){
        artistas = conexion.obtenerArtistas();
    }
    /**
     * metodo para eliminar el artista 
     * @param id_artista 
     */
    public void eliminarArtista(int id_artista) {
        System.out.println("Elimino Artista");
        conexion.eliminarArtistas(id_artista);

    }
/**
 * metodo para eliminar el artista
 * @param artista 
 */
    public void onRowEdit(Artista artista) {
        
        System.out.println("Edito Artista");                
        conexion.editarArtistas(artista);
    }
/**
 * metodo para la cancelacion del artista 
 * @param event 
 */
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Artista) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);                
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }        
}