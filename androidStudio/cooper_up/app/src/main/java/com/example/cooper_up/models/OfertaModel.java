package com.example.cooper_up.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OfertaModel implements Serializable {

    @SerializedName("id")
    private Integer id;

    @SerializedName("id_practica")
    private Integer id_practica;

    @SerializedName("id_estudiante")
    private Integer id_estudiante;

    @SerializedName("estado")
    private Integer estado;

    public Integer getId() {
        return id;
    }

    public Integer getId_practica() {
        return id_practica;
    }

    public Integer getId_estudiante() {
        return id_estudiante;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId_practica(Integer id_practica) {
        this.id_practica = id_practica;
    }

    public void setId_estudiante(Integer id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
