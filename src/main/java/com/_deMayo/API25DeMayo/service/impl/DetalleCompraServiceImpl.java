package com._deMayo.API25DeMayo.service.impl;

import com._deMayo.API25DeMayo.entity.DetalleCompraId;
import com._deMayo.API25DeMayo.entity.Detalle_compra;
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
    public List<Detalle_compra> getAllDetalleCompras(){
        return detalleCompraRepository.findAll();
    }

    @Override
    public Optional<Detalle_compra> getDetalleCompraById(DetalleCompraId id) {
        return detalleCompraRepository.findById(id);
    }

    @Override
    public Detalle_compra saveDetalleCompra(Detalle_compra detalle_compra) {
        return detalleCompraRepository.save(detalle_compra);
    }

    @Override
    public Detalle_compra updateDetalleCompra(DetalleCompraId id, Detalle_compra detalle_compra) {
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