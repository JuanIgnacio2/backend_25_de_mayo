package com._deMayo.API25DeMayo.controller;

import com._deMayo.API25DeMayo.entity.Usuarios;
import com._deMayo.API25DeMayo.security.JwtUtil;
import com._deMayo.API25DeMayo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam Integer legajo, @RequestParam String pass) {
        Usuarios user = usuarioService.authenticateUser(legajo, pass);
        if (user != null) {
            String token = jwtUtil.generateToken(String.valueOf(user.getLegajo()));
            return ResponseEntity.ok().body("Bearer " + token);
        }
        else{
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}
