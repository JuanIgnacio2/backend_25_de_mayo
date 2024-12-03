package com._deMayo.API25DeMayo.service.impl;

import com._deMayo.API25DeMayo.entity.DetalleCompraId;
import com._deMayo.API25DeMayo.entity.DetalleCompra;
import com._deMayo.API25DeMayo.repository.DetalleCompraRepository;
import com._deMayo.API25DeMayo.service.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {
    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Override
    public List<DetalleCompra> getAllDetalleCompras(){
        return detalleCompraRepository.findAll();
    }

    @Override
    public Optional<DetalleCompra> getDetalleCompraById(DetalleCompraId id) {
        return detalleCompraRepository.findById(id);
    }

    @Override
    public DetalleCompra saveDetalleCompra(DetalleCompra detalle_compra) {
        return detalleCompraRepository.save(detalle_compra);
    }

    public void saveAllDetalles(List<DetalleCompra> detalles) {
        detalleCompraRepository.saveAll(detalles);
    }

    @Override
    public DetalleCompra updateDetalleCompra(DetalleCompraId id, DetalleCompra detalle_compra) {
        return detalleCompraRepository.findById(id).map(detalleCompra -> {
            detalleCompra.setCantidad(detalle_compra.getCantidad());
            detalleCompra.setPrecio(detalle_compra.getPrecio());
            detalleCompra.setNombre(detalle_compra.getNombre());
            return detalleCompraRepository.save(detalleCompra);
        }).orElse(null);
    }

    @Override
    public Boolean deleteDetalleCompraById(DetalleCompraId id){
        return detalleCompraRepository.findById(id).map(detalleCompra -> {
            detalleCompraRepository.delete(detalleCompra);
            return true;
        }).orElse(false);
    }
}