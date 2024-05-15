package com.tfg.cooperapp.Services;

import com.tfg.cooperapp.Models.Alumno;
import com.tfg.cooperapp.Repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    // Solo para hacer pruebas
    public List<Alumno> getAllAlumnos(){ return alumnoRepository.findAll();}
    public Alumno getAlumnosById(Integer id){
        return alumnoRepository.findById(id).get();
    }
    public Alumno logIn(String correo) {
        return alumnoRepository.obtenerAlumnoCorreo(correo);
    }
    public Alumno register(Alumno alumno){ return alumnoRepository.save(alumno);}
}
