package com._deMayo.API25DeMayo.service;

import com._deMayo.API25DeMayo.entity.Usuarios;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuarios> getAllUsuarios();
    Optional<Usuarios> getUsuarioById(Integer legajo);
    Usuarios createUsuario(Usuarios usuario);
    Usuarios updateUsuario(Integer legajo, Usuarios usuarioDetalles);
    boolean deleteUsuario(Integer legajo);
    public Usuarios authenticateUser(Integer legajo, String contrasenia);
}
