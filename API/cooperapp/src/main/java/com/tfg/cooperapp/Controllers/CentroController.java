package com.tfg.cooperapp.Controllers;

import com.tfg.cooperapp.Models.Alumno;
import com.tfg.cooperapp.Models.Centro;
import com.tfg.cooperapp.Services.CentroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/centro")
@RestController
public class CentroController {

    @Autowired
    private CentroService centroService;

    @GetMapping("/allCentros")
    public List<Centro> getAllCorreos() {
        return centroService.getAllCentro();
    }

    @GetMapping("/centrosById/{id}")
    public Centro getAlumnos(@PathVariable Integer id) {
        return centroService.getCentroById(id);
    }

    @GetMapping("/logIn/{correo}")
    public Centro logIn(@PathVariable String correo) {
        return centroService.logIn(correo);

    }
}





