package com.tfg.cooperapp.Services;

import com.tfg.cooperapp.Models.Centro;

import com.tfg.cooperapp.Repositories.CentroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroService {

    @Autowired
    private CentroRepository centroRepository;

    public List<Centro> getAllCentro(){ return centroRepository.findAll();}
    public Centro getCentroById(Integer id){
        return centroRepository.findById(id).get();
    }
    public Centro logIn(String correo) {
        return centroRepository.obtenerCentroCorreo(correo);
    };
    public Centro register(Centro centro){ return centroRepository.save(centro);}

}
