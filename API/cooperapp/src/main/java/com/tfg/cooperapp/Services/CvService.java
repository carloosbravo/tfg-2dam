package com.tfg.cooperapp.Services;

import com.tfg.cooperapp.Models.CV;
import com.tfg.cooperapp.Repositories.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvService {

    @Autowired
    private CvRepository cvRepository;

    public CV getCvAlumno(Integer id_alumno) { return cvRepository.getCvalumno(id_alumno);}
}
