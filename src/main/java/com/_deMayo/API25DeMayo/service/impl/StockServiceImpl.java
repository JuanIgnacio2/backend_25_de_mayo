package com._deMayo.API25DeMayo.service.impl;

import com._deMayo.API25DeMayo.entity.DetalleCompra;
import com._deMayo.API25DeMayo.entity.Stock;
import com._deMayo.API25DeMayo.repository.StockRepository;
import com._deMayo.API25DeMayo.service.StockService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
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

    public List<Stock> findByNombre(String nombre) {
        return stockRepository.findByNombre(nombre);
    }

    @Override
    public List<Stock> getTop5ByTotalPrice(){
        Pageable topFive = PageRequest.of(0,5);
        return stockRepository.findTop5ByTotalPrice(topFive);
    }

    @Override
    public List<Map<String,String>> getAllTypes(){
        List<String> tipos = stockRepository.findDistinctTipo();
        return tipos.stream()
                .map(tipo -> Map.of(
                        "tipo", tipo,
                        "nombre", tipo
                ))
                .toList();
    }

    @Override
    public Stock saveStock(Stock stock){
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stockDetails){
        return stockRepository.findById(id)
                .map(stock -> {
                    stock.setCodigo_deposito(stockDetails.getCodigo_deposito());
                    stock.setNombre(stockDetails.getNombre());
                    stock.setCantidad(stockDetails.getCantidad());
                    stock.setUnidad(stockDetails.getUnidad());
                    stock.setTipo(stockDetails.getTipo());
                    stock.setStock_minimo(stockDetails.getStock_minimo());
                    stock.setPrecio(stockDetails.getPrecio());
                    return stockRepository.save(stock);
                }).orElse(null);
    }

    @Transactional
    public void actualizarStockPorCompra(DetalleCompra detalle, Integer codigoDeposito){
        Optional <Stock> optionalStock = stockRepository.findByNombre(detalle.getNombre())
                                                        .stream()
                                                        .findFirst();

        if(optionalStock.isPresent()){
            Stock stock = optionalStock.get();
            stock.setCantidad(stock.getCantidad() + detalle.getCantidad());
            stockRepository.save(stock);
        }else{
            Stock nuevoStock = new Stock();
            nuevoStock.setCantidad(detalle.getCantidad());
            nuevoStock.setCodigo_deposito(codigoDeposito);
            nuevoStock.setNombre(detalle.getNombre());
            nuevoStock.setUnidad(detalle.getUnidad());
            nuevoStock.setPrecio(detalle.getPrecio());
            nuevoStock.setTipo(detalle.getTipo());
            nuevoStock.setStock_minimo(0);
            stockRepository.save(nuevoStock);
        }
    }

    @Override
    public Boolean existsById(Long id) {
        return stockRepository.existsById(id);
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