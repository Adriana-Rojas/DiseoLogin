/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.musicbv.controller;

import com.udec.musicbv.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniel Barreto, Julian vallejo
 */
@Named(value = "paginaMaestra")
@RequestScoped
public class PaginaMaestra implements Serializable {
        

    public PaginaMaestra() {
    }           
    
    public String irLogin(){
    
        return "login.xhtml?faces-redirect=true";
    }
    
    public String irArtistas(){
    
        return "artistas.xhtml?faces-redirect=true";
    }
    
    public String irAlbumes(){
        
        return "albumes.xhtml?faces-redirect=true";
    }
    
    public String irCanciones(){
    
        return "canciones.xhtml?faces-redirect=true";
    }
    
    public void validarSesion() {
        System.out.println("Admin event!");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        try {
            Usuario usuario = (Usuario) session.getAttribute("sessionUser");                        
            if (usuario != null) {
                facesContext.getExternalContext().redirect("inicioAdmin.xhtml?faces-redirect=true");
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
}
