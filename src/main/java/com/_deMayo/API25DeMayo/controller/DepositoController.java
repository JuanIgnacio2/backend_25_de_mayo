package com._deMayo.API25DeMayo.controller;

import com._deMayo.API25DeMayo.entity.Depositos;
import com._deMayo.API25DeMayo.service.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/depositos")
public class DepositoController {
    @Autowired
    private DepositoService depositoService;

    @GetMapping
    public List<Depositos> getAllDepositos() {
        return depositoService.getAllDepositos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Depositos> getDepositoByCodigo(@PathVariable String codigo){
        Optional<Depositos> deposito = depositoService.getDepositoById(codigo);
        return deposito.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Depositos createDeposito(@RequestBody Depositos depositos){
        return depositoService.createDeposito(depositos);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Depositos> updateDeposito(@PathVariable String codigo, @RequestBody Depositos depositos){
        Depositos updatedDeposito = depositoService.updateDeposito(codigo, depositos);
        return updatedDeposito != null ? ResponseEntity.ok(updatedDeposito) : ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<String> deleteDeposito(@PathVariable String codigo){
        return depositoService.deleteDeposito(codigo) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
