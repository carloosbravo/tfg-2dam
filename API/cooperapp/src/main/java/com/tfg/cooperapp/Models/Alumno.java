package com.tfg.cooperapp.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "usuarionormal")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Alumno {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="email")
    private String email;

    @Column(name="contraseña")
    private String contraseña;

    @Column(name="expediente_academico")
    private String expediente_academico;

    @Column(name="valoracion_profesorado")
    private String valoracion_profesorado;

    @Column(name="centro_id")
    private Integer centro_id;

    @Column(name="telefono")
    private String telefono;
}
