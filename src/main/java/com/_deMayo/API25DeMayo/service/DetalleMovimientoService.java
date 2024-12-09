package com._deMayo.API25DeMayo.service;

import com._deMayo.API25DeMayo.entity.DetalleCompra;
import com._deMayo.API25DeMayo.entity.DetalleMovimiento;
import com._deMayo.API25DeMayo.entity.DetalleMovimientoId;

import java.util.List;
import java.util.Optional;

public interface DetalleMovimientoService {
    List<DetalleMovimiento> getAllDetalleMovimiento();
    Optional<DetalleMovimiento> getDetalleMovimientoById(Long id);
    DetalleMovimiento saveDetalleMovimiento(DetalleMovimiento detalleMovimiento);
    void saveAllDetalles(List<DetalleMovimiento> detalles);
    DetalleMovimiento updateDetalleMovimiento(Long id, DetalleMovimiento detalleMovimiento);
    Boolean deleteDetalleMovimiento(Long id);
}
