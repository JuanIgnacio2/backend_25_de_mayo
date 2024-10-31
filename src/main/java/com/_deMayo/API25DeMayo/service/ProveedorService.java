package com._deMayo.API25DeMayo.service;

import com._deMayo.API25DeMayo.entity.Proveedores;
import java.util.List;
import java.util.Optional;

public interface ProveedorService {
    List<Proveedores> getAllProveedores();
    Optional<Proveedores> getProveedorById(String cuit);
    Proveedores saveProveedor(Proveedores proveedor);
    Proveedores updateProveedor(String cuit, Proveedores proveedor);
    Boolean deleteProveedor(String cuit);
}
