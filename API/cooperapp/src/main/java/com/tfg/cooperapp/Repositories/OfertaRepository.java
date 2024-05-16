package com.tfg.cooperapp.Repositories;

import com.tfg.cooperapp.Models.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {
}
