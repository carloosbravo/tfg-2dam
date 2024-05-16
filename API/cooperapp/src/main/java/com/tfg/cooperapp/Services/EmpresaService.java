package com.tfg.cooperapp.Services;

import com.tfg.cooperapp.Models.Alumno;
import com.tfg.cooperapp.Models.Empresa;
import com.tfg.cooperapp.Repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    // Solo para hacer pruebas
    public List<Empresa> getAllEmpresa(){ return empresaRepository.findAll();}
    public Empresa getEmpresaById(Integer id){
        return empresaRepository.findById(id).get();
    }
    public Empresa logIn(String correo) {
        return empresaRepository.obtenerEmpresaCorreo(correo);
    }
    public Empresa register(Empresa empresa){ return empresaRepository.save(empresa);}
}
