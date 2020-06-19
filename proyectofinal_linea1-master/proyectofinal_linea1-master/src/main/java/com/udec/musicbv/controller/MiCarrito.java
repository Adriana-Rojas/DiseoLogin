/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.musicbv.controller;

import com.udec.musicbv.modelo.Cancion;
import com.udec.musicbv.modelo.Conexion;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Daniel Barreto, Julian vallejo
 */
@Named(value = "miCarito")
@ViewScoped
public class MiCarrito implements Serializable {

    @Inject
    private Carrito carrito;

    private Conexion conexion;

    private Cancion selectedCancion;

    /**
     * Creates a new instance of MisCompras
     */
    public MiCarrito() {
        conexion = new Conexion();
    }

    public Cancion getSelectedCancion() {
        return selectedCancion;
    }

    public void setSelectedCancion(Cancion selectedCancion) {
        this.selectedCancion = selectedCancion;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    /**
     * metodo encarfado de recorrer la lista y hacer la compra
     */
    public void comprar() {
        conexion.comprar(carrito.getListaCarrito(), carrito.getCedula(), carrito.getTotal());
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().invalidateSession();
    }

    /**
     * metodo encargado de eliminar cancion
     */
    public void eliminarCancion() {
        for (int i = 0; i < carrito.getListaCarrito().size(); i++) {
            if (carrito.getListaCarrito().get(i).getId() == selectedCancion.getId()) {
                carrito.getListaCarrito().remove(i);
                carrito.setTotal(carrito.getTotal() - selectedCancion.getPrecio());
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!", "Canción eliminada del carrito!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                break;
            }
        }
    }

    @PostConstruct
    public void init() {
    }

}
