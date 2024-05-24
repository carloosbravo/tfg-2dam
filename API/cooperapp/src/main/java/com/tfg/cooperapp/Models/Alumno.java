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

    @Column(name="dni")
    private String dni;

    @Column(name="grado")
    private String grado;

    @Column(name="centro_id")
    private Integer centro_id;

    @Column(name="telefono")
    private String telefono;
}
