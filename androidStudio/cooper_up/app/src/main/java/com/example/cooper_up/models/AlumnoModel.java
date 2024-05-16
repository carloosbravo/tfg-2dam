package com.example.cooper_up.models;

public class AlumnoModel {

    private int id;

    private String nombre;
    private String email;
    private String contraseña;
    private String cv;
    private String expediente_academico;
    private String valoracion_profesorado;


    public AlumnoModel() {
    }

    public AlumnoModel(int id, String nombre, String email, String contra, String cv, String expediente_academico, String valoracion_profesorado) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contra;
        this.cv = cv;
        this.expediente_academico = expediente_academico;
        this.valoracion_profesorado = valoracion_profesorado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContra() {
        return contraseña;
    }

    public void setContra(String contra) {
        this.contraseña = contra;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getExpediente_academico() {
        return expediente_academico;
    }

    public void setExpediente_academico(String expediente_academico) {
        this.expediente_academico = expediente_academico;
    }

    public String getValoracion_profesorado() {
        return valoracion_profesorado;
    }

    public void setValoracion_profesorado(String valoracion_profesorado) {
        this.valoracion_profesorado = valoracion_profesorado;
    }
}
