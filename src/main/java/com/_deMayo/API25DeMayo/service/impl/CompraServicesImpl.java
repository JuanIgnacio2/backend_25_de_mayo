package com._deMayo.API25DeMayo.service.impl;

import com._deMayo.API25DeMayo.repository.ComprasRepository;
import com._deMayo.API25DeMayo.service.CompraService;
import com._deMayo.API25DeMayo.entity.Compras;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class CompraServicesImpl implements CompraService {
    @Autowired
    private ComprasRepository comprasRepository;

    @Override
    public List<Compras> getAllCompras() {
        return comprasRepository.findAll();
    }

    @Override
    public Optional<Compras> getComprasById(Long id) {
        return comprasRepository.findById(id);
    }

    @Override
    public Compras createCompras(Compras compras) {
        return comprasRepository.save(compras);
    }

    @Override
    public Compras updateCompras(Long id, Compras compras) {
        return comprasRepository.findById(id).map(compra ->{
            compra.setCodigoCompra(compra.getCodigoCompra());
            compra.setFechaCompra(compra.getFechaCompra());
            compra.setCuitProveedor(compra.getCuitProveedor());
            compra.setCodigoDeposito(compra.getCodigoDeposito());
            return comprasRepository.save(compra);
        }).orElse(null);
    }

    @Override
    public boolean deleteCompra(Long id) {
        return comprasRepository.findById(id).map(compras -> {
            comprasRepository.delete(compras);
            return true;
        }).orElse(false);
    }
}
