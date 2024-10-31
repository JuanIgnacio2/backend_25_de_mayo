package com._deMayo.API25DeMayo.service;

import com._deMayo.API25DeMayo.entity.DetalleMovimiento;
import com._deMayo.API25DeMayo.entity.DetalleMovimientoId;

import java.util.List;
import java.util.Optional;

public interface DetalleMovimientoService {
    List<DetalleMovimiento> getAllDetalleMovimiento();
    Optional<DetalleMovimiento> getDetalleMovimientoById(DetalleMovimientoId id);
    DetalleMovimiento saveDetalleMovimiento(DetalleMovimiento detalleMovimiento);
    DetalleMovimiento updateDetalleMovimiento(DetalleMovimientoId id, DetalleMovimiento detalleMovimiento);
    Boolean deleteDetalleMovimiento(DetalleMovimientoId id);
}
