package com._deMayo.API25DeMayo.controller;

import com._deMayo.API25DeMayo.entity.Movimientos;
import com._deMayo.API25DeMayo.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public ResponseEntity<List<Movimientos>> getAllMovimientos() {
        return ResponseEntity.ok(movimientoService.getAllMovimientos());
    }

    @GetMapping("/{codigoMoviemiento}")
    public ResponseEntity<Movimientos> getMovimientosByCodigoMovimiento(@PathVariable Long codigoMovimiento) {
        return movimientoService.getMovimientoById(codigoMovimiento)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Movimientos> createMovimiento(@RequestBody Movimientos movimientos) {
        return ResponseEntity.ok(movimientoService.addMovimiento(movimientos));
    }

    @PutMapping("/{codigoMovimiento}")
    public ResponseEntity<Movimientos> updateMovimiento(@PathVariable Long codigoMovimiento, @RequestBody Movimientos movimientoDetalles) {
        Movimientos updateMovimiento = movimientoService.updateMovimiento(codigoMovimiento, movimientoDetalles);
        return updateMovimiento != null ? ResponseEntity.ok(updateMovimiento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigoMovimiento}")
    public ResponseEntity<Movimientos> deleteMovimiento(@PathVariable Long codigoMovimiento) {
        return movimientoService.deleteMovimiento(codigoMovimiento) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
