package com.tfg.cooperapp.Controllers;

import com.tfg.cooperapp.Models.Oferta;
import com.tfg.cooperapp.Services.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oferta")

public class OfertaController {

    @Autowired
    private OfertaService ofertaService;


    @GetMapping("/getAll")
    public List<Oferta> getAll() { return ofertaService.getAll();}

    @PostMapping("/addOferta")
    public Oferta addOferta(@RequestBody Oferta oferta){ return ofertaService.postOferta(oferta);}

    @DeleteMapping("deleteOferta/{id_practica}/{id_estudiante}")
    public void getOferta(@PathVariable Integer id_practica, @PathVariable Integer id_estudiante){
        System.out.println(id_practica + " -" + id_estudiante);
        Oferta oferta = ofertaService.getOferta(id_practica, id_estudiante);
        System.out.println(oferta);
        ofertaService.deleteOferta(oferta.getId());
    }



}
