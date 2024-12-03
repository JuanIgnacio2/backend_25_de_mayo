package com._deMayo.API25DeMayo.service;

import com._deMayo.API25DeMayo.entity.DetalleCompra;
import com._deMayo.API25DeMayo.entity.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {
    List<Stock> getAllStock();
    Optional<Stock> getStockById(Long id);
    List<Stock> findByNombre(String nombre);
    Stock saveStock(Stock stock);
    Stock updateStock(Long Id, Stock stockDetalles);
    void actualizarStockPorCompra(DetalleCompra detalle);
    Boolean existsById(Long id);
    Boolean deleteStock(Long id);
}
