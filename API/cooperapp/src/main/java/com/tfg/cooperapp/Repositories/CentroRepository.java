package com.tfg.cooperapp.Repositories;

import com.tfg.cooperapp.Models.Centro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroRepository extends JpaRepository<Centro, Integer> {

    @Query("SELECT a FROM Centro a WHERE a.email =?1")
    Centro obtenerCentroCorreo(String correo);
}
