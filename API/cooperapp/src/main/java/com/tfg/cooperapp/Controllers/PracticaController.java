package com.tfg.cooperapp.Controllers;

import com.tfg.cooperapp.Models.Practica;
import com.tfg.cooperapp.Services.PracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practica")
public class PracticaController {

    @Autowired
    private PracticaService practicaService;

    @GetMapping("/getAll")
    public List<Practica> getAll() { return practicaService.getAll();}

    @GetMapping("/byIdEmpresa/{id_empresa}")
    public List<Practica> getByIdEmpresa(@PathVariable Integer id_empresa) { return practicaService.getPracticasIdEmpresa(id_empresa);}

    @GetMapping("/byIdEstudiante/{id_estudiante}")
    public List<Practica> getByIdEstdudiante(@PathVariable Integer id_estudiante) { return practicaService.getPracticasEstdiante(id_estudiante);}


    @DeleteMapping("/delete/{id_practica}")
    public void deletePracticaById(@PathVariable Integer id_practica){
        practicaService.deletePracticaById(id_practica);
    }
}
