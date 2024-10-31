package com._deMayo.API25DeMayo.service;

import com._deMayo.API25DeMayo.entity.Movimientos;

import java.util.List;
import java.util.Optional;

public interface MovimientoService {
    List<Movimientos> getAllMovimientos();
    Optional<Movimientos> getMovimientoById(Long codigo);
    Movimientos addMovimiento(Movimientos movimiento);
    Movimientos updateMovimiento(Long codigo, Movimientos movimiento);
    Boolean deleteMovimiento(Long codigo);
}
