package com.tfg.cooperapp.Repositories;

import com.tfg.cooperapp.Models.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {

    @Query("SELECT o FROM Oferta o WHERE o.id_practica = ?1 AND o.id_estudiante = ?2")
    Oferta getOferta(Integer id_practica, Integer id_estudiante);
}
