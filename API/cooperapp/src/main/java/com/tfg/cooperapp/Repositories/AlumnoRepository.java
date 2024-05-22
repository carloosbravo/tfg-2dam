package com.tfg.cooperapp.Repositories;

import com.tfg.cooperapp.Models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    @Query("SELECT a FROM Alumno a WHERE a.email =?1")
    Alumno obtenerAlumnoCorreo(String correo);

    @Query("SELECT a FROM Alumno a WHERE a.centro_id =?1")
    List<Alumno> obtenerAlumnoCentro(Integer centro_id);
}

