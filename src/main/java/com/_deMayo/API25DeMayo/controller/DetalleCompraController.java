package com._deMayo.API25DeMayo.controller;

import com._deMayo.API25DeMayo.entity.DetalleCompraId;
import com._deMayo.API25DeMayo.entity.Detalle_compra;
import com._deMayo.API25DeMayo.service.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalleCompra")
public class DetalleCompraController {
    @Autowired
    private DetalleCompraService detalleCompraService;

    @GetMapping
    public ResponseEntity<List<Detalle_compra>> getAllDetalleCompra() {
        return ResponseEntity.ok(detalleCompraService.getAllDetalleCompras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detalle_compra> getDetalleCompraById(@PathVariable DetalleCompraId id) {
        return detalleCompraService.getDetalleCompraById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Detalle_compra> createDetalleCompra(@RequestBody Detalle_compra detalleCompra) {
        return ResponseEntity.ok(detalleCompraService.saveDetalleCompra(detalleCompra));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Detalle_compra> updateDetalleCompra(@PathVariable DetalleCompraId id, @RequestBody Detalle_compra detalleCompra) {
        Detalle_compra updateDetalleCompra = detalleCompraService.updateDetalleCompra(id, detalleCompra);
        return updateDetalleCompra != null ? ResponseEntity.ok(updateDetalleCompra) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Detalle_compra> deleteDetalleCompra(@PathVariable DetalleCompraId id) {
        return detalleCompraService.deleteDetalleCompraById(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
