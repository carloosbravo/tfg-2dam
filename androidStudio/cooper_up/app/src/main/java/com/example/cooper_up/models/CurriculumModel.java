package com.example.cooper_up.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CurriculumModel implements Serializable {

        @SerializedName("id")
        private Integer id;

        @SerializedName("descripcion")
        private String descripcion;

        @SerializedName("estudios")
        private String estudios;

        @SerializedName("lenguajes")
        private String lenguajes;

        @SerializedName("id_estudiante")
        private Integer id_estudiante;





}
