package com.tfg.cooperapp.Controllers;

import com.tfg.cooperapp.Models.Alumno;
import com.tfg.cooperapp.Services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // Se usa el mismo método post para registrar un nuevo alumno y para actualizar los datos de un alumno ya existente
    @PostMapping("/register-update")
    public Alumno registrarAlumno (@RequestBody Alumno alumno) {return alumnoService.register(alumno);}

    @GetMapping("/alumnoCentro/{centro_id}")
    public List<Alumno> getAlumnosCentro(@PathVariable Integer centro_id){ return alumnoService.getAlumnoCentro(centro_id);}

    @GetMapping("/alumnosPractica/{idPractica}")
    public List<Alumno> getAlumnosPractica(@PathVariable Integer idPractica){
        return alumnoService.getAlumnosByPracticaId(idPractica);
    }

    @DeleteMapping("/deleteAlumno/{dni}")
    public Integer deleteAlumnoDni(@PathVariable String dni){
        Alumno alumno = alumnoService.getAlumnoDni(dni);

        if (alumno != null){
            alumnoService.deleteAlumnoDni(alumno.getId());
            return 1;

        }else{
            return 0;
        }
    }

}
