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

        @SerializedName("idiomas")
        private String idiomas;

        @SerializedName("id_estudiante")
        private Integer id_estudiante;

        public String getIdiomas() {
                return idiomas;
        }

        public void setIdiomas(String idiomas) {
                this.idiomas = idiomas;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public void setDescripcion(String descripcion) {
                this.descripcion = descripcion;
        }

        public void setEstudios(String estudios) {
                this.estudios = estudios;
        }

        public void setLenguajes(String lenguajes) {
                this.lenguajes = lenguajes;
        }

        public void setId_estudiante(Integer id_estudiante) {
                this.id_estudiante = id_estudiante;
        }

        public Integer getId() {
                return id;
        }

        public String getDescripcion() {
                return descripcion;
        }

        public String getEstudios() {
                return estudios;
        }

        public String getLenguajes() {
                return lenguajes;
        }

        public Integer getId_estudiante() {
                return id_estudiante;
        }
}
