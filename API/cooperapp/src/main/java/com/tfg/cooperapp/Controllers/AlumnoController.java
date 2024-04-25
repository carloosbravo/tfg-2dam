package com.tfg.cooperapp.Controllers;

import com.tfg.cooperapp.Models.Alumno;
import com.tfg.cooperapp.Services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/usuarionormal")
@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/allAlumnos/{id}")
    public Alumno getAlumnos(@PathVariable  Integer id) {
        return alumnoService.getAllAlumnos(id);
    }

    @GetMapping("/logIn/{correo}")
    public Alumno logIn(@PathVariable String correo){
        return alumnoService.logIn(correo);
    }
}
