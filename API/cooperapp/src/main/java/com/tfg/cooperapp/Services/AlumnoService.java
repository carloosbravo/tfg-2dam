package com.tfg.cooperapp.Services;

import com.tfg.cooperapp.Models.Alumno;
import com.tfg.cooperapp.Repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public Alumno getAllAlumnos(Integer id){
        return alumnoRepository.findById(id).get();
    }
    public Alumno logIn(String correo) {
        return alumnoRepository.obtenerAlumnoCorreo(correo);
    };
}
