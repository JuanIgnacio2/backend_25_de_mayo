package com._deMayo.API25DeMayo.repository;

import com._deMayo.API25DeMayo.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>{
    Optional<Usuarios> findByLegajoAndContrasenia(Integer legajo, String contrasenia);
}
