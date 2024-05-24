package com.tfg.cooperapp.Services;

import com.tfg.cooperapp.Models.Practica;
import com.tfg.cooperapp.Repositories.PracticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticaService {

    @Autowired
    private PracticaRepository practicaRepository;

    public List<Practica> getAll() { return practicaRepository.findAll();}

    public List<Practica> getPracticasIdEmpresa(Integer id_empresa) {return practicaRepository.getPracticasIdEmpresa(id_empresa);}

    public List<Practica> getPracticasEstdiante(Integer id_estudiante) {return practicaRepository.getPracticasEstudiante(id_estudiante);}

    public Practica publicarPrcatica(Practica practica) {return practicaRepository.save(practica);}
    
    public void deletePracticaById(Integer id_practica){
         practicaRepository.deleteById(id_practica);
    }


}
