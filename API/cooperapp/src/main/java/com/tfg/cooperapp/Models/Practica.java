package com.tfg.cooperapp.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "practica")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Practica {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="id_empresa")
    private Integer id_empresa;
}