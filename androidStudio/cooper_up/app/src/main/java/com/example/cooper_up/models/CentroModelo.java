package com.example.cooper_up.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CentroModelo implements Serializable {

    @SerializedName("id")
    private Integer id;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("email")
    private String email;

    @SerializedName("direccion")
    private String direccion;

    @SerializedName("contraseña")
    private String contraseña;

    @SerializedName("telefono")
    private String telefono;

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getTelefono() {
        return telefono;
    }
}
