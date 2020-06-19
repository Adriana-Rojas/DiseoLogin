/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elecciones.beans;

import com.mycompany.elecciones.modelo.Controlador;
import com.mycompany.elecciones.modelo.pojo.Candidato;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 * Bean de la vista del formulario de inscripción de candidatos
 * @author Daniel Barreto
 */
@ManagedBean
@RequestScoped
public class Index implements Serializable {

    /**
     *Variable que instancia un objeto de la clase Candidato
     */
    private Candidato candidato;

    /**
     *Variable que permite instanciar al objeto Lista
     */
    @ManagedProperty("#{lista}")
    private Lista lista;

    /**
     *Variable que recibe el archivo de la foto
     */
    private UploadedFile file;

    /**
     * Creates a new instance of Index
     */
    public Index() {
        System.out.println("Constructor!!!");
        candidato = new Candidato();
    }

    /**
     * Getter de la variable File
     * @return File
     */
    public UploadedFile getFile() {
        return file;
    }

    /**
     * Setter de la variable File
     * @param file 
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }

    /**
     * Getter de la variable Lista
     * @return Lista
     */
    public Lista getLista() {
        return lista;
    }

    /**
     * Setter de la variable Lista
     * @param lista 
     */
    public void setLista(Lista lista) {
        this.lista = lista;
    }

    /**
     * Getter de la variable Candidato
     * @return 
     */
    public Candidato getCandidato() {
        return candidato;
    }

    /**
     * Setter de la variable Candidato
     * @param candidato 
     */
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    /**
     * Metodo que realiza el submit del formulario
     * @throws IOException 
     */
    public void agregarCandidato() throws IOException {
        if (file != null) {
            String fileName = System.currentTimeMillis()+ file.getFileName();
            candidato.setFoto(fileName);
            Controlador controlador = new Controlador();
            try {
                if (controlador.agregarCandidato(candidato, lista.getCandidatos())) {
                    lista.getCandidatos().add(candidato);
                    System.out.println(lista.getCandidatos());
                    InputStream in = file.getInputstream();
                    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                    String path = ec.getRealPath("/");
                    String fol = path + File.separator;                    
                    Path folder = Paths.get(fol);
                    Path fileToCreate = folder.resolve(fileName);
                    System.out.println(fol);
                    Files.copy(in, Files.createFile(fileToCreate), StandardCopyOption.REPLACE_EXISTING);
                    FacesMessage msg = new FacesMessage("Aviso", "Candidato Agregado!!");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage("Aviso", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } else {
            FacesMessage msg = new FacesMessage("Aviso", "Seleccione una imagen!!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        System.out.println(file.getFileName());
    }

}
