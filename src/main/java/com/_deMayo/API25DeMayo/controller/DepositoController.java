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

    @GetMapping("/{codigoDeposito}")
    public ResponseEntity<Depositos> getDepositoByCodigo(@PathVariable Integer codigoDeposito){
        Optional<Depositos> deposito = depositoService.getDepositoById(codigoDeposito);
        return deposito.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Depositos createDeposito(@RequestBody Depositos depositos){
        return depositoService.createDeposito(depositos);
    }

    @PutMapping("/{codigoDeposito}")
    public ResponseEntity<Depositos> updateDeposito(@PathVariable Integer codigoDeposito, @RequestBody Depositos depositos){
        Depositos updatedDeposito = depositoService.updateDeposito(codigoDeposito, depositos);
        return updatedDeposito != null ? ResponseEntity.ok(updatedDeposito) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigoDeposito}")
    public ResponseEntity<String> deleteDeposito(@PathVariable Integer codigoDeposito){
        return depositoService.deleteDeposito(codigoDeposito) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
