package com.example.cooper_up.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PracticaModel implements Serializable {

    @SerializedName("id")
    private Integer id;

    @SerializedName("titulo")
    private String titulo_practica;
    @SerializedName("descripcion")
    private String descripcion;

    @SerializedName("id_empresa")
    private Integer id_empresa;

    public Integer getId() {
        return id;
    }

    public String getTitulo_practica() {
        return titulo_practica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getId_empresa() {
        return id_empresa;
    }
}
