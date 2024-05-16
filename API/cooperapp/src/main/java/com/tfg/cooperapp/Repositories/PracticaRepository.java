package com.tfg.cooperapp.Repositories;

import com.tfg.cooperapp.Models.Practica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PracticaRepository extends JpaRepository<Practica, Integer> {

    @Query("SELECT p FROM Practica p WHERE id_empresa = ?1")
    List<Practica> getPracticasIdEmpresa(Integer id_empresa);

    @Query("SELECT p FROM Practica p JOIN Oferta o ON p.id = o.id_practica WHERE o.id_estudiante = ?1")
    List<Practica> getPracticasEstudiante(Integer idEstudiante);
}
