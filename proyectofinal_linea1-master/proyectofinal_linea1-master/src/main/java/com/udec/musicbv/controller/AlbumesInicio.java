/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.musicbv.controller;

import com.udec.musicbv.modelo.AlbumJoin;
import com.udec.musicbv.modelo.Cancion;
import com.udec.musicbv.modelo.Conexion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Daniel Barreto, Julian vallejo
 */
@Named(value = "albumesInicio")
@ViewScoped
public class AlbumesInicio implements Serializable {

    private List<AlbumJoin> albumes;
    private List<Cancion> canciones;
    private AlbumJoin selectAlbum;
    private Cancion selectedCancion;
    Conexion conexion;

    @Inject
    private Carrito carrito;

    @PostConstruct
    public void listarArtistas() {

        albumes = new ArrayList<>();
        canciones = new ArrayList<>();
        selectAlbum = new AlbumJoin();
        conexion = new Conexion();

        albumes = conexion.obtenerAlbumes();
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Cancion getSelectedCancion() {
        return selectedCancion;
    }

    public void setSelectedCancion(Cancion selectedCancion) {
        this.selectedCancion = selectedCancion;
    }

    public List<Cancion> listarCancionesAlbum() {
        canciones = conexion.obteberCanciones(selectAlbum.getId_disco());
        return canciones;
    }

    public List<AlbumJoin> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(List<AlbumJoin> albumes) {
        this.albumes = albumes;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public AlbumJoin getSelectAlbum() {
        return selectAlbum;
    }

    public void setSelectAlbum(AlbumJoin selectAlbum) {
        this.selectAlbum = selectAlbum;
    }

    /**
     * metodo para agregar cancion al carrito
     */
    public void agregarCancionCarrito() {
        if (carrito.getListaCarrito().contains(selectedCancion)) {
            System.out.println("Contains!!!!!");
        }
        boolean enLista = false;
        for (Cancion cancion : carrito.getListaCarrito()) {
            if (cancion.getId() == selectedCancion.getId()) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Esta canción ya ha sido agregada!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                enLista = true;
                break;
            }
        }
        if (!enLista) {
            carrito.getListaCarrito().add(selectedCancion);
            carrito.setTotal(carrito.getTotal() + selectedCancion.getPrecio());
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!", "Canción agregada al carrito!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void agregarAlbumCarrito() {
        boolean existe = false;
        List<Cancion> cancionesAlbum = conexion.obteberCanciones(selectAlbum.getId_disco());
        for (Cancion cancionCarrito : carrito.getListaCarrito()) {
            for (Cancion cancionAlbum : cancionesAlbum) {
                if (cancionAlbum.getId() == cancionCarrito.getId()) {
                    existe = true;
                    break;
                }
            }
        }
        if (existe) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta!",
                "Alguna de las canciones de este álbum ya existe en el carrito, "
                + "No se puede agregar este álbum al carrito de compras!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            for (Cancion cancion : cancionesAlbum) {
                carrito.setTotal(carrito.getTotal() + cancion.getPrecio());
            }
            carrito.getListaCarrito().addAll(cancionesAlbum);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta!",
                "Las canciones de este Álbum fueron agregadas al carrito de compras con exito!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
