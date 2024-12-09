package com._deMayo.API25DeMayo.service.impl;

import com._deMayo.API25DeMayo.entity.DetalleMovimiento;
import com._deMayo.API25DeMayo.entity.Movimientos;
import com._deMayo.API25DeMayo.repository.MovimientosRepository;
import com._deMayo.API25DeMayo.service.MovimientoService;
import jakarta.transaction.Transactional;
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
    @Transactional
    public Movimientos addMovimiento(Movimientos movimiento) {
        Movimientos savedMovimiento = movimientosRepository.save(movimiento);

        for(DetalleMovimiento detalle: movimiento.getDetalleMovimientos()){
            detalle.setMovimiento(savedMovimiento);
        }
        return savedMovimiento;
    }

    @Override
    @Transactional
    public Movimientos updateMovimiento(Long codigo, Movimientos movimientoDetails){
        Optional<Movimientos> existingMovimientoOpt = movimientosRepository.findById(codigo);

        if(existingMovimientoOpt.isPresent()){
            Movimientos existingMovimiento = existingMovimientoOpt.get();

            existingMovimiento.getDetalleMovimientos().clear();
            movimientosRepository.save(existingMovimiento);

            for(DetalleMovimiento detalle: movimientoDetails.getDetalleMovimientos()){
                detalle.setMovimiento(existingMovimiento);
            }
            return movimientosRepository.save(existingMovimiento);
        }
        return null;
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