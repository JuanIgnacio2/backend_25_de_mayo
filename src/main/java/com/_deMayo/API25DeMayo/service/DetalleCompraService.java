package com._deMayo.API25DeMayo.service;

import com._deMayo.API25DeMayo.entity.DetalleCompraId;
import com._deMayo.API25DeMayo.entity.DetalleCompra;
import java.util.List;
import java.util.Optional;

public interface DetalleCompraService {
    List<DetalleCompra> getAllDetalleCompras();
    Optional<DetalleCompra> getDetalleCompraById(DetalleCompraId id);
    DetalleCompra saveDetalleCompra(DetalleCompra detalle_compra);
    void saveAllDetalles(List<DetalleCompra> detalles);
    DetalleCompra updateDetalleCompra(DetalleCompraId id, DetalleCompra detalle_compra);
    Boolean deleteDetalleCompraById(DetalleCompraId id);
}
