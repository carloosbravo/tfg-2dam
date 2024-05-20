package com.example.cooper_up.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EmpresaModelo implements Serializable {

    @SerializedName("id")
    private Integer id;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("email")
    private String email;

    @SerializedName("contraseña")
    private String contraseña;

    @SerializedName("direccion")
    private String direccion;

    @SerializedName("telefono")
    private String telefono;

    @SerializedName("biografia")
    private String biografia;


    public void setId(Integer id) {
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


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }



    public Integer getId() {
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


    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getBiografia() {
        return biografia;
    }


}
