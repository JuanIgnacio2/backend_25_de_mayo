package com._deMayo.API25DeMayo.controller;

import com._deMayo.API25DeMayo.entity.Compras;
import com._deMayo.API25DeMayo.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @GetMapping
    public ResponseEntity<List<Compras>> getAllCompras(){
        return ResponseEntity.ok(compraService.getAllCompras());
    }

    @GetMapping("/{codigoCompra}")
    public ResponseEntity<Compras> getCompraByCodigo(@PathVariable Long codigoCompra){
        return compraService.getComprasById(codigoCompra)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Compras> createCompra(@RequestBody Compras compras){
        return ResponseEntity.ok(compraService.createCompras(compras));
    }

    @PutMapping("/{codigoCompra}")
    public ResponseEntity<Compras> updateCompra(@PathVariable Long codigoCompra, @RequestBody Compras compraDetalles){
        Compras updatedCompra = compraService.updateCompras(codigoCompra,compraDetalles);
        return updatedCompra == null ? ResponseEntity.ok(updatedCompra):ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigoCompra}")
    public ResponseEntity<Compras> deleteCompra(@PathVariable Long codigoCompra){
        return compraService.deleteCompra(codigoCompra)?ResponseEntity.noContent().build():ResponseEntity.notFound().build();
    }
}