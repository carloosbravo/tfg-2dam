package com.tfg.cooperapp.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "cv")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CV {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="estudios")
    private String estudios;

    @Column(name="lenguajes")
    private String lenguajes;

    @Column(name="id_alumno")
    private Integer id_alumno;



}
