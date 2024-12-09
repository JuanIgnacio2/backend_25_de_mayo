package com._deMayo.API25DeMayo.controller;

import com._deMayo.API25DeMayo.entity.Proveedores;
import com._deMayo.API25DeMayo.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedores> getAllProveedores() {
        return proveedorService.getAllProveedores();
    }

    @GetMapping("/{cuit}")
    public ResponseEntity<Proveedores> getProveedoreById(@PathVariable String cuit) {
        Optional<Proveedores> proveedor = proveedorService.getProveedorById(cuit);
        return proveedor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Proveedores createProveedor(@RequestBody Proveedores proveedor) {
        return proveedorService.saveProveedor(proveedor);
    }

    @PutMapping
    public ResponseEntity<Proveedores> updateProveedor(@PathVariable String cuit, @RequestBody Proveedores proveedorDetalles) {
        Proveedores updatedProveedor = proveedorService.updateProveedor(cuit, proveedorDetalles);
        return updatedProveedor != null ? ResponseEntity.ok(updatedProveedor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cuit}")
    public ResponseEntity<Proveedores> deleteProveedor(@PathVariable String cuit) {
        return proveedorService.deleteProveedor(cuit) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
