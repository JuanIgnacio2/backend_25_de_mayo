package com._deMayo.API25DeMayo.controller;

import com._deMayo.API25DeMayo.entity.DetalleMovimiento;
import com._deMayo.API25DeMayo.entity.DetalleMovimientoId;
import com._deMayo.API25DeMayo.service.DetalleMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/detalleMoviemiento")
public class DetalleMovimientoController {
    @Autowired
    private DetalleMovimientoService detalleMovimientoService;

    @GetMapping
    public ResponseEntity<List<DetalleMovimiento>> getAllDetalleMovimiento() {
        return ResponseEntity.ok(detalleMovimientoService.getAllDetalleMovimiento());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleMovimiento> getDetalleMovimientoById(@PathVariable DetalleMovimientoId id) {
        return detalleMovimientoService.getDetalleMovimientoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DetalleMovimiento> createDetalleMovimiento(@RequestBody DetalleMovimiento detalleMovimiento) {
        return ResponseEntity.ok(detalleMovimientoService.saveDetalleMovimiento(detalleMovimiento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleMovimiento> updateDetalleMovimiento(@PathVariable DetalleMovimientoId id, @RequestBody DetalleMovimiento detalleMovimientoDetails) {
        DetalleMovimiento updateDetalleMovimiento = detalleMovimientoService.updateDetalleMovimiento(id, detalleMovimientoDetails);
        return updateDetalleMovimiento != null ? ResponseEntity.ok(updateDetalleMovimiento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetalleMovimiento> deleteDetalleMovimiento(@PathVariable DetalleMovimientoId id) {
        return detalleMovimientoService.deleteDetalleMovimiento(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
