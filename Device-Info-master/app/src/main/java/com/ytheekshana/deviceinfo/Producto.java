package com.ytheekshana.deviceinfo;

public class Producto {
    private String id,tipoaplicativo;

    public Producto() {
    }

    public Producto(String id, String tipoaplicativo) {
        this.id = id;
        this.tipoaplicativo = tipoaplicativo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoaplicativo() {
        return tipoaplicativo;
    }

    public void setTipoaplicativo(String tipoaplicativo) {
        this.tipoaplicativo = tipoaplicativo;
    }

    @Override
    public String toString() {
        return tipoaplicativo;
    }

}
