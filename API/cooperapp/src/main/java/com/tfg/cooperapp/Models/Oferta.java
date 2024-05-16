package com.tfg.cooperapp.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.jdbc.TinyIntAsSmallIntJdbcType;

@Entity
@Table(name= "oferta")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Oferta {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="id_practica")
    private Integer id_practica;

    @Column(name="id_estudiante")
    private Integer id_estudiante;

    @Column(name="estado")
    private Integer estado;

}

