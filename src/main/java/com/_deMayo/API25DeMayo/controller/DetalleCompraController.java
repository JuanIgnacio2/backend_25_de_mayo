package com._deMayo.API25DeMayo.controller;

import com._deMayo.API25DeMayo.entity.DetalleCompraId;
import com._deMayo.API25DeMayo.entity.DetalleCompra;
import com._deMayo.API25DeMayo.service.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalleCompra")
public class DetalleCompraController {
    @Autowired
    private DetalleCompraService detalleCompraService;

    @GetMapping
    public ResponseEntity<List<DetalleCompra>> getAllDetalleCompra() {
        return ResponseEntity.ok(detalleCompraService.getAllDetalleCompras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleCompra> getDetalleCompraById(@PathVariable DetalleCompraId id) {
        return detalleCompraService.getDetalleCompraById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DetalleCompra> createDetalleCompra(@RequestBody DetalleCompra detalleCompra) {
        return ResponseEntity.ok(detalleCompraService.saveDetalleCompra(detalleCompra));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleCompra> updateDetalleCompra(@PathVariable DetalleCompraId id, @RequestBody DetalleCompra detalleCompra) {
        DetalleCompra updateDetalleCompra = detalleCompraService.updateDetalleCompra(id, detalleCompra);
        return updateDetalleCompra != null ? ResponseEntity.ok(updateDetalleCompra) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetalleCompra> deleteDetalleCompra(@PathVariable DetalleCompraId id) {
        return detalleCompraService.deleteDetalleCompraById(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
