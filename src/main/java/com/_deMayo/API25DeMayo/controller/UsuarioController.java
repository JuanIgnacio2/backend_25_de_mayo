package com._deMayo.API25DeMayo.controller;

import com._deMayo.API25DeMayo.entity.Usuarios;
import com._deMayo.API25DeMayo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuarios>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    @GetMapping("/{legajo}")
    public ResponseEntity<Usuarios> getUsuarioByLegajo(@PathVariable Integer legajo) {
        return usuarioService.getUsuarioById(legajo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuarios> createUsuario(@RequestBody Usuarios usuario) {
        return ResponseEntity.ok(usuarioService.createUsuario(usuario));
    }

    @PutMapping("/{legajo}")
    public ResponseEntity<Usuarios> updateUsuario(@PathVariable Integer legajo, @RequestBody Usuarios usuario) {
        Usuarios updateUsuario = usuarioService.updateUsuario(legajo, usuario);
        return updateUsuario != null ? ResponseEntity.ok(updateUsuario) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{legajo}")
    public ResponseEntity<Usuarios> deleteUsuario(@PathVariable Integer legajo) {
        return usuarioService.deleteUsuario(legajo) ? ResponseEntity.noContent().build():ResponseEntity.notFound().build();
    }
}
