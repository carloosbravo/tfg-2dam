package com.tfg.cooperapp.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "centro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Centro {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="email")
    private String email;

    @Column(name="direccion")
    private String direccion;

    @Column(name="contraseña")
    private String contraseña;

    @Column(name="telefono")
    private String telefono;
}
