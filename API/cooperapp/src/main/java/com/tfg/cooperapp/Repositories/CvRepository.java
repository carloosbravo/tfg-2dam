package com.tfg.cooperapp.Repositories;

import com.tfg.cooperapp.Models.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CvRepository extends JpaRepository<CV, Integer> {

    @Query("SELECT c FROM CV c WHERE c.id_estudiante = ?1")
    CV findByStudentId(Integer studentId);
}
