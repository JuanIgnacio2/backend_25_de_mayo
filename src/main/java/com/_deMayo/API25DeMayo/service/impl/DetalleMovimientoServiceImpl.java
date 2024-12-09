package com._deMayo.API25DeMayo.service.impl;

import com._deMayo.API25DeMayo.entity.DetalleCompra;
import com._deMayo.API25DeMayo.entity.DetalleMovimiento;
import com._deMayo.API25DeMayo.entity.DetalleMovimientoId;
import com._deMayo.API25DeMayo.service.DetalleMovimientoService;
import com._deMayo.API25DeMayo.repository.DetalleMovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleMovimientoServiceImpl implements DetalleMovimientoService {
    @Autowired
    private DetalleMovimientoRepository detalleMovimientoRepository;

    @Override
    public List<DetalleMovimiento> getAllDetalleMovimiento(){
        return detalleMovimientoRepository.findAll();
    }

    @Override
    public Optional<DetalleMovimiento> getDetalleMovimientoById(Long id){
        return detalleMovimientoRepository.findById(id);
    }

    @Override
    public DetalleMovimiento saveDetalleMovimiento(DetalleMovimiento detalleMovimiento){
        return detalleMovimientoRepository.save(detalleMovimiento);
    }

    public void saveAllDetalles(List<DetalleMovimiento> detalles) {
        detalleMovimientoRepository.saveAll(detalles);
    }

    @Override
    public DetalleMovimiento updateDetalleMovimiento(Long id, DetalleMovimiento detalleMovimientoDetalles){
        return detalleMovimientoRepository.findById(id)
                .map(detalleMovimiento ->{
                    detalleMovimiento.setCantidad(detalleMovimientoDetalles.getCantidad());
                    detalleMovimiento.setPrecioTotal(detalleMovimientoDetalles.getPrecioTotal());
                    return detalleMovimientoRepository.save(detalleMovimiento);
                }).orElse(null);
    }

    @Override
    public Boolean deleteDetalleMovimiento(Long id){
        return detalleMovimientoRepository.findById(id)
                .map(detalleMovimiento -> {
                    detalleMovimientoRepository.delete(detalleMovimiento);
                    return true;
                }).orElse(false);
    }
}
