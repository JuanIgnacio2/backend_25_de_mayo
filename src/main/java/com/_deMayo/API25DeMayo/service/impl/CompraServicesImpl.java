package com._deMayo.API25DeMayo.service.impl;

import com._deMayo.API25DeMayo.entity.DetalleCompra;
import com._deMayo.API25DeMayo.repository.ComprasRepository;
import com._deMayo.API25DeMayo.service.CompraService;
import com._deMayo.API25DeMayo.service.DetalleCompraService;
import com._deMayo.API25DeMayo.service.StockService;
import com._deMayo.API25DeMayo.entity.Compras;
import com._deMayo.API25DeMayo.entity.DetalleCompraId;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class CompraServicesImpl implements CompraService {
    @Autowired
    private ComprasRepository comprasRepository;

    @Autowired
    private DetalleCompraService detalleCompraService;

    @Autowired
    private StockService stockService;

    @Override
    public List<Compras> getAllCompras() {
        return comprasRepository.findAll();
    }

    @Override
    public Optional<Compras> getComprasById(Long id) {
        return comprasRepository.findById(id);
    }

    @Override
    @Transactional
    public Compras createCompras(Compras compras) {
        Compras savedCompra = comprasRepository.save(compras);

        for (DetalleCompra detalle : compras.getDetalleCompras()) {
            detalle.setCompra(savedCompra);
            System.out.println("Detalle antes de guardar: " + detalle);
        }

        detalleCompraService.saveAllDetalles(compras.getDetalleCompras());

        for (DetalleCompra detalle : compras.getDetalleCompras()) {
            stockService.actualizarStockPorCompra(detalle);
        }
        System.out.println("Compra y detalles guardados: " + savedCompra);
        return savedCompra;
    }

    @Override
    @Transactional
    public Compras updateCompras(Long id, Compras compras) {
        Optional<Compras> existingCompraOpt = comprasRepository.findById(id);

        if (existingCompraOpt.isPresent()) {
            Compras existingCompra = existingCompraOpt.get();

            existingCompra.getDetalleCompras().clear();

            existingCompra.setCuitProveedor(compras.getCuitProveedor());
            existingCompra.setFechaCompra(compras.getFechaCompra());
            existingCompra.setCodigoDeposito(compras.getCodigoDeposito());

            Compras updatedCompras = comprasRepository.save(existingCompra);

            for (DetalleCompra detalle : compras.getDetalleCompras()) {
                detalle.setCompra(updatedCompras);
                detalleCompraService.saveDetalleCompra(detalle);
                stockService.actualizarStockPorCompra(detalle);
            }

            return updatedCompras;
        }
        return null;
    }

    @Override
    public boolean deleteCompra(Long id) {
        return comprasRepository.findById(id).map(compras -> {
            comprasRepository.delete(compras);
            return true;
        }).orElse(false);
    }
}