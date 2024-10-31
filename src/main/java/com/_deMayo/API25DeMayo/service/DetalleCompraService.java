package com._deMayo.API25DeMayo.service;

import com._deMayo.API25DeMayo.entity.DetalleCompraId;
import com._deMayo.API25DeMayo.entity.Detalle_compra;
import java.util.List;
import java.util.Optional;

public interface DetalleCompraService {
    List<Detalle_compra> getAllDetalleCompras();
    Optional<Detalle_compra> getDetalleCompraById(DetalleCompraId id);
    Detalle_compra saveDetalleCompra(Detalle_compra detalle_compra);
    Detalle_compra updateDetalleCompra(DetalleCompraId id, Detalle_compra detalle_compra);
    Boolean deleteDetalleCompraById(DetalleCompraId id);
}
