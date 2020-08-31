package com.ytheekshana.deviceinfo;

public class Employeevaluados {
    private String id,nombre;



    public Employeevaluados() {
    }

    public Employeevaluados(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
