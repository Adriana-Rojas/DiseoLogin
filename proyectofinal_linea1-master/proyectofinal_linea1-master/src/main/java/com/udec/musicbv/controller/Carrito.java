/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.musicbv.controller;

import com.udec.musicbv.modelo.Cancion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Daniel Barreto, Julian vallejo
 */
@Named(value = "carrito")
@SessionScoped
public class Carrito implements Serializable {

    private List<Cancion> listaCarrito;
    private int cedula;
    private int total;   
    
    /**
     * Creates a new instance of Carrito
     */
    public Carrito() {
        //listaCarrito = new ArrayList<>();
    }

    public List<Cancion> getListaCarrito() {
        return listaCarrito;
    }

    public void setListaCarrito(List<Cancion> listaCarrito) {
        this.listaCarrito = listaCarrito;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    @PostConstruct
    public void init(){
        listaCarrito = new ArrayList<>();
        total = 0;
    }
    
}
