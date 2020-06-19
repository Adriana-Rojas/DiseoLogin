/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elecciones.beans;

import com.mycompany.elecciones.modelo.Controlador;
import com.mycompany.elecciones.modelo.pojo.Candidato;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Daniel Barreto
 */
@ManagedBean
@ViewScoped
public class Votaciones implements Serializable {

    /**
     *Variable que permite usar la clase Lista
     */
    @ManagedProperty(value = "#{lista}")
    private Lista lista;

    /**
     *Variable que almacena el candidato por el que se vota
     */
    private Candidato candidato;

    /**
     * Creates a new instance of Votaciones
     */
    public Votaciones() {
    }
    
    /**
     * Variable que instancia la gráfica de resultados
     */
    private PieChartModel livePieModel;
    
    

    /**
     * Getter de la variable de la grafica
     * @return Grafica PieChart
     */
    public PieChartModel getLivePieModel() {
        return livePieModel;
    }

    /**
     * Setter de la grafica
     * @param livePieModel 
     */
    public void setLivePieModel(PieChartModel livePieModel) {
        this.livePieModel = livePieModel;
    }

    /**
     * Getter de la lista de candidatos
     * @return Candidatos
     */
    public Lista getLista() {
        return lista;
    }

    /**
     * Setter de la variable de la lista
     * @param lista 
     */
    public void setLista(Lista lista) {
        this.lista = lista;
    }

    /**
     * Getter de la variable Candidato
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
     * Metodo que se ejecuta después de que el constructor termine
     */
    @PostConstruct
    public void init() {
        createLivePieModel();
    }
    

    /**
     * Metodo que se ejecuta cuando se selecciona un candidato
     * @param event 
     */
    public void onRowSelect(SelectEvent event) {
        Controlador controlador = new Controlador();
        Candidato c = ((Candidato) event.getObject());
        try {
            String infoVoto = controlador.votar(c, lista.getCandidatos());
            FacesMessage msg = new FacesMessage("Aviso", infoVoto);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            createLivePieModel();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Aviso", "Ha ocurrido un error al procesar tu voto");
            System.err.println(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
    
    /**
     * Metodo que configura la grafica
     */
    private void createLivePieModel() {
        livePieModel = new PieChartModel();
        for (Candidato c : (List<Candidato>)lista.getCandidatos()) {
            livePieModel.set(c.getNombre(), c.getVotos());
        }
        livePieModel.setTitle("Candidatos");
        livePieModel.setLegendPosition("w");
        livePieModel.setShadow(false);
    }

}

