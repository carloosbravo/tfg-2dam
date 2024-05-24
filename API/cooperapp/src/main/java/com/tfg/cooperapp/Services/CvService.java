package com.tfg.cooperapp.Services;

import com.tfg.cooperapp.Models.CV;
import com.tfg.cooperapp.Repositories.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvService {

    @Autowired
    private CvRepository cvRepository;

    public CV getCvAlumno(Integer id_alumno) { return cvRepository.findByStudentId(id_alumno);}
    public CV actualizar(CV cv) { return cvRepository.save(cv);}
}
