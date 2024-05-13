package com.example.cooper_up.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PracticaModel implements Serializable {

    @SerializedName("id")
    private Integer id;

    @SerializedName("nombre_practica")
    private String nombre_practica;
    @SerializedName("descripcion")
    private String descripcion;

    @SerializedName("id_empresa")
    private Integer id_empresa;

    public Integer getId() {
        return id;
    }

    public String getNombre_practica() {
        return nombre_practica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getId_empresa() {
        return id_empresa;
    }
}
