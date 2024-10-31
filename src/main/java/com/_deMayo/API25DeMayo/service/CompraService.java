package com._deMayo.API25DeMayo.service;

import com._deMayo.API25DeMayo.entity.Compras;
import java.util.Optional;
import java.util.List;

public interface CompraService {
    public List<Compras> getAllCompras();
    public Optional<Compras> getComprasById(Long id);
    Compras createCompras(Compras compras);
    Compras updateCompras(Long id, Compras compras);
    boolean deleteCompras(Long id);
}
