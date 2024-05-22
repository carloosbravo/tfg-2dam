package com.example.cooper_up.models;

import java.io.Serializable;

public class AlumnoModel implements Serializable {

    private int id;

    private String nombre;
    private String email;
    private String contraseña;

    private String telefono;
    private String expediente_academico; //DNI
    private String valoracion_profesorado; //grado cursado


    public AlumnoModel() {
    }

    public AlumnoModel(int id, String nombre, String email, String contraseña,String telefono , String expediente_academico, String valoracion_profesorado) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.expediente_academico = expediente_academico;
        this.valoracion_profesorado = valoracion_profesorado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getExpediente_academico() {
        return expediente_academico;
    }

    public String getValoracion_profesorado() {
        return valoracion_profesorado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setExpediente_academico(String expediente_academico) {
        this.expediente_academico = expediente_academico;
    }

    public void setValoracion_profesorado(String valoracion_profesorado) {
        this.valoracion_profesorado = valoracion_profesorado;
    }
}
