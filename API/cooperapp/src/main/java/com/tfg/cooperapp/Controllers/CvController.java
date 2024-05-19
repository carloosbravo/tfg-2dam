package com.tfg.cooperapp.Controllers;

import com.tfg.cooperapp.Models.CV;
import com.tfg.cooperapp.Services.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cv")
public class CvController {

    @Autowired
    private CvService cvService;

    @GetMapping("/getCV/{id_alumno}")
    public CV getCvAlumno(@PathVariable Integer id_alumno) { return cvService.getCvAlumno(id_alumno);}
}