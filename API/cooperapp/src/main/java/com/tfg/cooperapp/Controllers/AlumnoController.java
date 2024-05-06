package com.tfg.cooperapp.Controllers;

import com.tfg.cooperapp.Models.Alumno;
import com.tfg.cooperapp.Services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/usuarionormal")
@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;


    @GetMapping("/allAlumnos")
    public List<Alumno> getAllAlumnos() { return alumnoService.getAllAlumnos();}

    @GetMapping("/alumnosById/{id}")
    public Alumno getAlumnos(@PathVariable  Integer id) {
        return alumnoService.getAlumnosById(id);
    }

    @GetMapping("/logIn/{correo}")
    public Alumno logIn(@PathVariable String correo){
        return alumnoService.logIn(correo);
    }
}
