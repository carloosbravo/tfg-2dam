package com.tfg.cooperapp.Repositories;

import com.tfg.cooperapp.Models.Alumno;
import com.tfg.cooperapp.Models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    @Query("SELECT a FROM Empresa a WHERE a.email =?1")
    Empresa obtenerEmpresaCorreo(String correo);
}
