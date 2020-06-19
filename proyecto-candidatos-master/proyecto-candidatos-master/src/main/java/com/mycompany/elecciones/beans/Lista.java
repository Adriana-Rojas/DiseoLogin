/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elecciones.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Bean que almacena una lista de Candidatos
 * @author Daniel Barreto
 */
@ManagedBean
@SessionScoped
public class Lista implements Serializable {

    /**
     * Lista que tiene a todos los candidatos inscritos
     */
    private List candidatos;

    /**
     * Creates a new instance of Lista
     */
    public Lista() {
        candidatos = new ArrayList<>();
    }

    /**
     * Getter de la lista de candidatos
     * @return 
     */
    public List getCandidatos() {
        return candidatos;
    }

    /**
     * Setter de la lista de candidatos
     * @param candidatos 
     */
    public void setCandidatos(List candidatos) {
        this.candidatos = candidatos;
    }
}
