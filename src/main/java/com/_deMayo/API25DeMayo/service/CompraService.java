package com._deMayo.API25DeMayo.service;

import com._deMayo.API25DeMayo.entity.Compras;
import java.util.Optional;
import java.util.List;

public interface CompraService {
    List<Compras> getAllCompras();
    Optional<Compras> getComprasById(Long id);
    Compras createCompras(Compras compras);
    Compras updateCompras(Long id, Compras compras);
    boolean deleteCompra(Long id);
}
