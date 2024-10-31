package com._deMayo.API25DeMayo.service.impl;

import com._deMayo.API25DeMayo.entity.Usuarios;
import com._deMayo.API25DeMayo.repository.UsuariosRepository;
import com._deMayo.API25DeMayo.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public abstract class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public Optional<Usuarios> getUsuarioById(String legajo){
        return usuariosRepository.findById(legajo);
    }

    @Override
    public Usuarios createUsuario(Usuarios usuario){
        return usuariosRepository.save(usuario);
    }

    @Override
    public Usuarios updateUsuario(String legajo, Usuarios usuarioDetalles){
        return usuariosRepository.findById(legajo)
                .map(usuario -> {
                    usuario.setNombre(usuarioDetalles.getNombre());
                    usuario.setApellido(usuarioDetalles.getApellido());
                    usuario.setDni(usuarioDetalles.getDni());
                    usuario.setCargo(usuarioDetalles.getCargo());
                    usuario.setContrasenia(usuarioDetalles.getContrasenia());
                    return usuariosRepository.save(usuario);
                }).orElse(null);
    }

    @Override
    public boolean deleteUsuario(String legajo){
        return usuariosRepository.findById(legajo)
                .map(usuario ->{
                    usuariosRepository.delete(usuario);
                    return true;
                })
                .orElse(false);
    }
}
