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
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Daniel Barreto, Julian vallejo
 */
@Named(value = "artistasInicio")
@ViewScoped
public class ArtistasInicio implements Serializable{

    /**
     * Creates a new instance of ArtistasInicio
     */
    
    private List<Artista> artistas;
    private Artista selectArtista;
    Conexion conexion;
    
    public ArtistasInicio() {            
    }
    @PostConstruct
    public void listarArtistas(){
    
        artistas = new ArrayList<>();
        selectArtista = new Artista();
        conexion = new Conexion();
        
        artistas = conexion.obtenerArtistas();
    }

    public Artista getSelectArtista() {
        return selectArtista;
    }

    public void setSelectArtista(Artista selectArtista) {
        this.selectArtista = selectArtista;
    }   
    
    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }       
}
