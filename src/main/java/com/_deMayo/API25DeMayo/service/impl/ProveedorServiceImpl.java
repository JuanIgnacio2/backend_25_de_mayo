package com._deMayo.API25DeMayo.service.impl;

import com._deMayo.API25DeMayo.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com._deMayo.API25DeMayo.repository.ProveedoresRepository;
import com._deMayo.API25DeMayo.entity.Proveedores;
import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {
    @Autowired
    private ProveedoresRepository proveedorRepository;

    @Override
    public List<Proveedores> getAllProveedores(){
        return proveedorRepository.findAll();
    }

    @Override
    public Optional<Proveedores> getProveedorById(String cuit){
        return proveedorRepository.findById(cuit);
    }

    @Override
    public Proveedores saveProveedor(Proveedores proveedor){
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedores updateProveedor(String cuit, Proveedores proveedor){
        return proveedorRepository.findById(cuit).map(proveedores -> {
            proveedores.setNombre(proveedor.getNombre());
            proveedores.setDireccion(proveedor.getDireccion());
            return proveedorRepository.save(proveedor);
        }).orElse(null);
    }

    @Override
    public Boolean deleteProveedor(String cuit){
        return proveedorRepository.findById(cuit)
                .map(proveedores -> {
                    proveedorRepository.delete(proveedores);
                    return true;
                }).orElse(false);
    }
}