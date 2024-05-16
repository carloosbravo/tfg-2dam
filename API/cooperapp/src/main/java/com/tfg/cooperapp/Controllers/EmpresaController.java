package com.tfg.cooperapp.Controllers;

import com.tfg.cooperapp.Models.Alumno;
import com.tfg.cooperapp.Models.Empresa;
import com.tfg.cooperapp.Services.AlumnoService;
import com.tfg.cooperapp.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/empresa")
@RestController
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/allEmpresas")
    public List<Empresa> getAllEmpresas() { return empresaService.getAllEmpresa();}

    @GetMapping("/empresaById/{id}")
    public Empresa getEmpresa(@PathVariable Integer id) {
        return empresaService.getEmpresaById(id);
    }

    @GetMapping("/logIn/{correo}")
    public Empresa logIn(@PathVariable String correo){
        return empresaService.logIn(correo);
    }

    @PostMapping("/register-update")
    public Empresa register(@RequestBody Empresa empresa) { return empresaService.register(empresa);}
}
