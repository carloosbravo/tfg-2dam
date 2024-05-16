package com.tfg.cooperapp.Services;

import com.tfg.cooperapp.Models.Oferta;
import com.tfg.cooperapp.Repositories.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfertaService {

    @Autowired
    private OfertaRepository ofertaRepository;

    public Oferta postOferta(Oferta oferta) {
        return ofertaRepository.save(oferta);
    }
}
