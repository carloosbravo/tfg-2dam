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

    @SerializedName("cv")
    private String cv;

    @SerializedName("direccion")
    private String direccion;

    @SerializedName("telefono")
    private String telefono;

    @SerializedName("valoracion_profesorado")
    private String valoracion_profesorado;

    @SerializedName("biografia")
    private Integer biografia;

    @SerializedName("oferta_practicas")
    private Integer oferta_practicas;

    @SerializedName("oferta_trabajo")
    private Integer oferta_trabajo;
}
