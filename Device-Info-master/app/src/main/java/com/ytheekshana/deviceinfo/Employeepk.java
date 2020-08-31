package com.ytheekshana.deviceinfo;

public class Employeepk {
    private String id,usuario,nombre,tipoaplicativo,subirapk,subirmanual,evaluador,listaaplicaciones;


    public Employeepk() {
    }

    public Employeepk(String id, String usuario, String nombre, String tipoaplicativo, String subirapk, String subirmanual, String evaluador, String listaaplicaciones) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.tipoaplicativo = tipoaplicativo;
        this.subirapk = subirapk;
        this.subirmanual = subirmanual;
        this.evaluador = evaluador;
        this.listaaplicaciones = listaaplicaciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoaplicativo() {
        return tipoaplicativo;
    }

    public void setTipoaplicativo(String tipoaplicativo) {
        this.tipoaplicativo = tipoaplicativo;
    }

    public String getSubirapk() {
        return subirapk;
    }

    public void setSubirapk(String subirapk) {
        this.subirapk = subirapk;
    }

    public String getSubirmanual() {
        return subirmanual;
    }

    public void setSubirmanual(String subirmanual) {
        this.subirmanual = subirmanual;
    }

    public String getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(String evaluador) {
        this.evaluador = evaluador;
    }

    public String getListaaplicaciones() {
        return listaaplicaciones;
    }

    public void setListaaplicaciones(String listaaplicaciones) {
        this.listaaplicaciones = listaaplicaciones;
    }

}
