package com._deMayo.API25DeMayo.service.impl;

import com._deMayo.API25DeMayo.repository.StockRepository;
import com._deMayo.API25DeMayo.service.StockService;
import com._deMayo.API25DeMayo.entity.Stock;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> getAllStock(){
        return stockRepository.findAll();
    }

    @Override
    public Optional<Stock> getStockById(Long id){
        return stockRepository.findById(id);
    }

    @Override
    public Stock saveStock(Stock stock){
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stockDetalles){
        return stockRepository.findById(id)
                .map(stock -> {
                    stock.setCodigoDeposito(stockDetalles.getCodigoDeposito());
                    stock.setNombre(stockDetalles.getNombre());
                    stock.setCantidad(stockDetalles.getCantidad());
                    stock.setStockMinimo(stockDetalles.getStockMinimo());
                    stock.setStockMaximo(stockDetalles.getStockMaximo());
                    stock.setPrecio(stockDetalles.getPrecio());
                    return stockRepository.save(stock);
                }).orElse(null);
    }

    @Override
    public Boolean deleteStock(Long id){
        return stockRepository.findById(id)
                .map(stock ->{
                    stockRepository.delete(stock);
                    return true;
                }).orElse(false);
    }
}