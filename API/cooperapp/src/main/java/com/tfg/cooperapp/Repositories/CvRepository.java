package com.tfg.cooperapp.Repositories;

import com.tfg.cooperapp.Models.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepository extends JpaRepository<CV, Integer> {

    @Query("SELECT c FROM CV c WHERE cv.id_alumno = ?1")
    CV getCvalumno(Integer id_alumno);
}
