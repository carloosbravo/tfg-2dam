package com.tfg.cooperapp.Controllers;

import com.tfg.cooperapp.Models.Oferta;
import com.tfg.cooperapp.Services.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oferta")

public class OfertaController {

    @Autowired
    private OfertaService ofertaService;

    @PostMapping("/addOferta")
    public Oferta addOferta(@RequestBody Oferta oferta){ return ofertaService.postOferta(oferta);}

}
