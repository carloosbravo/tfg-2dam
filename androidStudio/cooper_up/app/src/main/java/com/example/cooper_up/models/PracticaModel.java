package com.example.cooper_up.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PracticaModel {

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

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo_practica() {
        return titulo_practica;
    }

    public void setTitulo_practica(String titulo_practica) {
        this.titulo_practica = titulo_practica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Integer id_empresa) {
        this.id_empresa = id_empresa;
    }
}
