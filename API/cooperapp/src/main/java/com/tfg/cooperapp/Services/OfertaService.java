package com.tfg.cooperapp.Services;

import com.tfg.cooperapp.Models.Oferta;
import com.tfg.cooperapp.Repositories.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfertaService {

    @Autowired
    private OfertaRepository ofertaRepository;

    public List<Oferta> getAll() { return ofertaRepository.findAll();}

    public Oferta postOferta(Oferta oferta) {
        return ofertaRepository.save(oferta);
    }

    public Oferta getOferta(Integer id_practica, Integer id_estudiante) { return ofertaRepository.getOferta(id_practica, id_estudiante );}
    public void deleteOferta(Integer id) { ofertaRepository.deleteById(id);}
}
