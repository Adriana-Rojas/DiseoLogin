/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elecciones.modelo;

import com.mycompany.elecciones.modelo.pojo.Candidato;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Daniel Barreto
 */
public class Controlador {

    /**
     * Constructor de la clase Controlador
     */
    public Controlador() {
    }

    /**
     * MEtodo que guarda el voto realizado
     * @param candidato Candidato elegido
     * @param candidatos Lista de candidatos
     * @return Un caracter vacío
     * @throws Exception 
     */
    public String votar(Candidato candidato, List<Candidato> candidatos) throws Exception {
        for (Candidato c : (ArrayList<Candidato>) candidatos) {
            if (c.equals(candidato)) {
                c.setVotos(c.getVotos() + 1);
                String msg = "Has votado por: " + c.getNombre()
                        + " " + c.getApellido() + ". Total votos: " + c.getVotos();
                return msg;
            }
        }
        return "";
    }

    /**
     * Metodo que agrega el candidato con la fotografía
     * @param candidato Objeto candidato
     * @param candidatos Lista de candidatos
     * @param file Archivo a subir
     * @param folder ruta donde se guardará el archivo
     * @param fileName nombre del archivo
     * @return true si todo fue correcto
     * @throws Exception 
     */
    public boolean agregarCandidato(Candidato candidato, List<Candidato> candidatos, UploadedFile file, String folder, String fileName) throws Exception {
        try {
            FileInputStream fis = (FileInputStream) file.getInputstream();
            FileOutputStream fos = new FileOutputStream(folder + fileName);
            byte[] buffer = new byte[(int) file.getSize()];
            int cont;
            while ((cont = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, cont);
            }
            for (Candidato c : (ArrayList<Candidato>) candidatos) {
                if (Objects.equals(c.getCedula(), candidato.getCedula())) {
                    throw new Exception("El candidato que desea registrar ya existe");
                }
            }
            fis.close();
            fos.close();
        } catch (IOException e) {
            throw new IOException("Error al guardar la imagen");
        }

        return true;
    }

    /**
     * Metodo que verifica si el candidato no ha sido agregado
     * @param candidato Objeto Candidato a agregar
     * @param candidatos Lista de candidatos agregados
     * @return true si el candidato no existe
     * @throws Exception 
     */
    public boolean agregarCandidato(Candidato candidato, List<Candidato> candidatos) throws Exception {
        for (Candidato c : (ArrayList<Candidato>) candidatos) {
            if (Objects.equals(c.getCedula(), candidato.getCedula())) {
                throw new Exception("El candidato que desea regiatrar ya existe");
            }
        }
        return true;
    }
    
    /**
     * Metodo que permite consultar que candidato tiene más votos
     * @param candidatos Lista de candidatos
     * @return El candidato con más votos, o el error en caso de no poder definirse
     * @throws Exception 
     */
    public Candidato obtenerGanador(List<Candidato> candidatos) throws Exception{
        Integer max = 0;
        ArrayList<Integer> indexC = new ArrayList<>();
        for (Candidato c : candidatos) {
            if (c.getVotos() > max) {
                max = c.getVotos();
            }
        }

        for (Candidato c : candidatos) {
            if (Objects.equals(c.getVotos(), max)) {
                indexC.add(candidatos.indexOf(c));
            }
        }

        if (indexC.size() == 1) {
            return candidatos.get(indexC.get(0));
        } else if (indexC.isEmpty()) {
            throw new Exception("No hay ganador, no hubo votos!!");
        } else if (indexC.size() > 1) {
            throw new Exception("Empate entre " + indexC.size() + " candidatos!!!");
        }
        return null;
    }
}
