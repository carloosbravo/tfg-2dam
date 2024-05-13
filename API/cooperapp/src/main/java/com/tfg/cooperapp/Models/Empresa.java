package com.tfg.cooperapp.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "empresa")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Empresa {

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

    @Column(name="cv")
    private String cv;

    @Column(name="direccion")
    private String direccion;

    @Column(name="telefono")
    private String telefono;

    @Column(name="valoracion_profesorado")
    private String valoracion_profesorado;

    @Column(name="biografia")
    private Integer biografia;

    @Column(name="oferta_practicas")
    private Integer oferta_practicas;

    @Column(name="oferta_trabajo")
    private Integer oferta_trabajo;


}
