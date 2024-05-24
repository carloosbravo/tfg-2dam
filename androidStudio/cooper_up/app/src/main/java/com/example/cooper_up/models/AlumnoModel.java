package com.example.cooper_up.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AlumnoModel implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("nombre")
    private String nombre;
    @SerializedName("email")
    private String email;
    @SerializedName("contraseña")
    private String contraseña;

    @SerializedName("telefono")
    private String telefono;

    @SerializedName("dni")
    private String dni;

    @SerializedName("grado")
    private String grado;
    @SerializedName("centro_id")
    private int centro_id;

    public int getCentro_id() {
        return centro_id;
    }

    public void setCentro_id(int centro_id) {
        this.centro_id = centro_id;
    }

    public AlumnoModel() {
    }

    public AlumnoModel(int id, String nombre, String email, String contraseña,String telefono , String expediente_academico, String valoracion_profesorado) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.dni = expediente_academico;
        this.grado = valoracion_profesorado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
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


}
