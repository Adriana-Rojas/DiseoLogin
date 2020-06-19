/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.musicbv.controller;

import com.udec.musicbv.modelo.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniel Barreto, Julian vallejo
 */

@Named(value = "paginaMaestraAdmin")
@RequestScoped
public class PaginaMaestraAdmin {
    
    public String irArtistas(){
        
        return "artistasAdmin.xhtml?faces-redirect=true";
    }
    
    public String irAlbumes(){
    
        return "albumesAdmin.xhtml?faces-redirect=true";
    }
    
    public String irCanciones(){
    
        return "cancionesAdmin.xhtml?faces-redirect=true";
    }
    
    public String irReportes(){
    
        return "reportes.xhtml?faces-redirect=true";
    }
    /**
     * metodo encargado de validar la sesion del usuario
     */
    
    public void validarSesion() {
        System.out.println("Admin event!");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        try {
            Usuario usuario = (Usuario) session.getAttribute("sessionUser");                        
            if (usuario == null) {
                System.out.println("User null!");
                facesContext.getExternalContext().redirect("login.xhtml?faces-redirect=true");
            }
        } catch (IOException e) {
            System.out.println("Bienvenido!");
            try {
                facesContext.getExternalContext().redirect("login.xhtml?faces-redirect=true");
            } catch (IOException ex) {
                Logger.getLogger(PaginaMaestraAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * metodo encargado de cerrar la sesion del admin
     */
    public void cerrarSesion() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().invalidateSession();
        try {
            facesContext.getExternalContext().redirect("login.xhtml?faces-redirect=true");
        } catch (IOException ex) {
            Logger.getLogger(PaginaMaestraAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
