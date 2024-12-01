package com._deMayo.API25DeMayo.service.impl;

import com._deMayo.API25DeMayo.entity.Movimientos;
import com._deMayo.API25DeMayo.repository.MovimientosRepository;
import com._deMayo.API25DeMayo.service.MovimientoService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {
    @Autowired
    private MovimientosRepository movimientosRepository;

    @Override
    public List<Movimientos> getAllMovimientos() {
        return movimientosRepository.findAll();
    }

    @Override
    public Optional<Movimientos> getMovimientoById(Long id) {
        return movimientosRepository.findById(id);
    }

    @Override
    public Movimientos addMovimiento(Movimientos movimiento) {
        return movimientosRepository.save(movimiento);
    }

    @Override
    public Movimientos updateMovimiento(Long codigo, Movimientos movimientoDetails){
        return movimientosRepository.findById(codigo)
                .map(movimientos -> {
                    movimientos.setDetalle(movimientoDetails.getDetalle());
                    movimientos.setDesde(movimientoDetails.getDesde());
                    movimientos.setHasta(movimientoDetails.getHasta());
                    movimientos.setFecha(movimientoDetails.getFecha());
                    movimientos.setTipoMovimiento(movimientoDetails.getTipoMovimiento());
                    return movimientosRepository.save(movimientos);
                }).orElse(null);
    }

    @Override
    public Boolean deleteMovimiento(Long codigo){
        return movimientosRepository.findById(codigo)
                .map(movimientos -> {
                    movimientosRepository.delete(movimientos);
                    return true;
                }).orElse(false);
    }
}
