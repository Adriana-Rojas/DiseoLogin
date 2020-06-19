/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elecciones.beans;

import com.mycompany.elecciones.modelo.Controlador;
import com.mycompany.elecciones.modelo.pojo.Candidato;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Bean de la vista Resultados
 * @author Daniel Barreto
 */
@ManagedBean
@ViewScoped
public class Resultados implements Serializable {

    /**
     *Variable que permite usar al bean Lista
     */
    @ManagedProperty("#{lista}")
    private Lista candidatos;

    /**
     *Variable que almacena el candidato ganador
     */
    private Candidato candidato;
    
    /**
     * Variable que permite desplegar la información dependiendo del resultado de la consulta
     */
    private boolean error;
    
    /**
     * Variable que contiene el titulo de la pagina dependiendo del resultado de la consulta
     */
    private String titulo;
    
    /**
     * Creates a new instance of Resultados
     */
    public Resultados() {
        this.error=false;
        this.titulo="¡Ganador!";
    }

    /**
     * Getter de la variable titulo
     * @return Titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter de la variable titulo
     * @param titulo 
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /**
     * Getter de la variable error
     * @return Error
     */
    public boolean isError() {
        return error;
    }

    /**
     * Setter de la variable Error
     * @param error 
     */
    public void setError(boolean error) {
        this.error = error;
    }
    

    /**
     * Getter de la variable candidato
     * @return Candidato
     */
    public Candidato getCandidato() {
        return candidato;
    }

    /**
     * Setter de la variable candidato
     * @param candidato 
     */
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    /**
     * Getter de la lista de candidatos
     * @return 
     */
    public Lista getCandidatos() {
        return candidatos;
    }

    /**
     * Setter de la lista de candidatos
     * @param candidatos 
     */
    public void setCandidatos(Lista candidatos) {
        this.candidatos = candidatos;
    }

    /**
     * Metodo que se ejecuta tan pronto el constructor del bean termina, genera la consulta del ganador
     */
    @PostConstruct
    private void obtenerGanador() {
        Controlador controlador = new Controlador();
        
        try {
            candidato = controlador.obtenerGanador(candidatos.getCandidatos());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            FacesMessage msg = new FacesMessage("Aviso", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            this.error=true;
            this.titulo="¡Ups!";
        }
    }
}
