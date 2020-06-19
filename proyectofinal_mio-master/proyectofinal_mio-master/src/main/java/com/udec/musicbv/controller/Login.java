/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.musicbv.controller;

import com.udec.musicbv.modelo.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Daniel Barreto, Julian vallejo
 */
@Named(value = "login")
@ViewScoped
public class Login implements Serializable{
    
    @NotNull
    private String usuario;
    @NotNull
    private String clave;

    public Login() {
    }      
    /**
     * metodo que valida las credenciales del usuario que intenta acceder al sistema
     */
    public void iniciarSesion(){
        if ("esteban".equals(usuario) && "123".equals(clave)) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Usuario user = new Usuario(usuario,clave);
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            session.setAttribute("sessionUser", user);
            FacesContext.getCurrentInstance().getApplication().getNavigationHandler().
                    handleNavigation(FacesContext.getCurrentInstance(), null, "inicioAdmin.xhtml?faces-redirect=true");            
        } else {
            System.out.println("Usuario y/o contraseña incorrectos!!");
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario y/o contraseña incorrectos!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }          
}
